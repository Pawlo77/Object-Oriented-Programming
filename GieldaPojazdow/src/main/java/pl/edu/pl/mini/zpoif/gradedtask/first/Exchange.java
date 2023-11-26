package pl.edu.pl.mini.zpoif.gradedtask.first;

import pl.edu.pl.mini.zpoif.gradedtask.first.products.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Exchange implements Exchangeable{
    @Override
    public Collection<?> parseFile(String path) throws ParsingException {
        Collection<Towar> parsedObjects = new ArrayList<>();

        if (path == null || path.isEmpty()) {
            throw new ParsingException("Empty file path") {};
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split("-");

                    parsedObjects.add(switch (data[0]) {
                        case "auto" -> new Samochod(
                            Double.parseDouble(data[1].replace(',', '.')), Double.parseDouble(data[4]), data[2], data[3], data[5].equals("bezwypadkowy")
                        );
                        case "moto" -> new Motocykl(
                                Double.parseDouble(data[1].replace(',', '.')), Double.parseDouble(data[4]), data[2], data[3], Byte.parseByte(data[5])
                        );
                        case "horse" -> new Kon(
                                Double.parseDouble(data[1].replace(',', '.')), Double.parseDouble(data[4]), data[2], Byte.parseByte(data[3])
                        );
                        default -> new InnyTowar(Double.parseDouble(data[1].replace(',', '.')), data[2]);
                    });

                } catch (Exception e) {
                    throw new ParsingException("Error reading line " + line, e) {};
                }
            }

        } catch (IOException e) {
            throw new ParsingException("Error reading file", e) {};
        }

        return parsedObjects;
    }

    @Override
    public Collection<?> getSortedVehicles(Collection<?> parsedStuffs) {
        Collection<Towar> towars = new TreeSet<>();

        for (Object towar: parsedStuffs) {
            Towar towar1 = (Towar) towar;
            if (towar1.isOkey()) {
                towars.add(towar1);
            }
        }

        return towars;
    }

    @Override
    public Collection<?> getHorses(Collection<?> parsedStuff) {
        Comparator<Kon> horseComparator = (h1, h2) -> Integer.compare(h2.getWiek(), h1.getWiek());
        Collection<Kon> horses = new TreeSet<>(horseComparator);

        for (Object towar: parsedStuff) {
            Towar towar1 = (Towar) towar;
            if (towar1.isHorse()) {
                horses.add((Kon) towar1);
            }
        }

        return horses;
    }

    public static void main(String[] args) {
        Exchangeable exchange = new Exchange();
        Collection<?> collection;

        try {
            collection = exchange.parseFile("src/main/resources/towary.txt");
        } catch (ParsingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
        System.out.println(exchange.getSortedVehicles(collection));
        System.out.println(exchange.getHorses(collection));

    }
}
