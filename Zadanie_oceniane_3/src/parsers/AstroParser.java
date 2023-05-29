package parsers;

import buffers.MyUnforgvingBufferedReader;
import models.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AstroParser {

    public static List<InformacjaOgolna> parseReliableAsteroidInformation(String filePath) throws SrednicaNieMaSensuException, IOException {
        Set<InformacjaOgolna> result = new TreeSet<>();

        // to działa, ale poniezej jest wersja co korzysta z naszego MyUnforgvingBufferedReader
//        Scanner scanner = new Scanner(Objects.requireNonNull(AstroParser.class.getClassLoader().getResourceAsStream("asteroidy.txt")));
//        scanner.useDelimiter("____");
//        while (scanner.hasNext()) {
//            result.add(parseAstreoid(scanner));
//            scanner.nextLine();
//        }

        MyUnforgvingBufferedReader bufferedReader = new MyUnforgvingBufferedReader(new InputStreamReader(Objects.requireNonNull(AstroParser.class.getClassLoader().getResourceAsStream("asteroidy.txt"))));

        String line;
        Scanner scanner;
        while ((line = bufferedReader.myReadLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter("____");
            result.add(parseAstreoid(scanner));
        }


        return new ArrayList<>(result);
    }

    private static InformacjaOgolna parseAstreoid(Scanner scanner) throws SrednicaNieMaSensuException {
        int id = Integer.parseInt(scanner.next().trim());
        String nazwa = scanner.next().trim();

        String[] srednicaString = scanner.next().trim().split("--");
        double min = Double.parseDouble(srednicaString[0].substring(1));
        double max = Double.parseDouble(srednicaString[1].substring(0, srednicaString[1].length() - 1));
//        if (min > max) throw new SrednicaNieMaSensuException("models.Srednica astreoidy o id " + id + " nie ma sensu.");
        Srednica srednica = new Srednica(min, max);

        boolean zagrozenieDlaZiemi = scanner.next().trim().equals("Ja");

        if (!zagrozenieDlaZiemi) return new InformacjaOgolna(id, nazwa, srednica);

        String dataBliskiegoPodejscia = scanner.next().trim();
        double predkosc = Double.parseDouble(scanner.next().trim());
        double dystans = Double.parseDouble(scanner.next().trim());

        String orbitujeWokolString = scanner.next().trim();
        ObiektyOrbitowalne orbitujeWokol;
        if (orbitujeWokolString.equals("Earth")) orbitujeWokol = ObiektyOrbitowalne.ZIEMIA;
        else if (orbitujeWokolString.equals("")) orbitujeWokol = ObiektyOrbitowalne.BRAK_DANYCH;
        else orbitujeWokol = ObiektyOrbitowalne.INNE;

        String link = scanner.next().trim();
        return new InformacjaSzczegolowa(id, nazwa, srednica, zagrozenieDlaZiemi, dataBliskiegoPodejscia, predkosc, dystans, orbitujeWokol, link);
    }
}
