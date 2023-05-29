import java.io.FileNotFoundException;
import java.util.*;

public class MyParser {
    public static List<Osoba> parsePatients(String filePath) throws FileNotFoundException, DublicatedIdException {
        List<Osoba> result = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        Scanner scanner = new Scanner(Objects.requireNonNull(MyParser.class.getClassLoader().getResourceAsStream(filePath)));
        scanner.useDelimiter("#");

        Osoba osoba;
        while (scanner.hasNextLine()) {
            osoba = parsePatient(scanner);
            if (ids.contains(osoba.getId()))
                throw new DublicatedIdException("Id " + osoba.getId() + " pojawiło się więcej niż jeden raz");

            ids.add(osoba.getId());
            result.add(osoba);
            scanner.nextLine();
        }

        return result;
    }

    private static Osoba parsePatient(Scanner scanner) {
        int id = Integer.parseInt(scanner.next().trim());
        String plec = scanner.next().trim();
        int wiek = Integer.parseInt(scanner.next().trim());
        double temperatura = Double.parseDouble(scanner.next().trim());
        boolean kaszel = Boolean.parseBoolean(scanner.next().trim());
        String sth = scanner.next().trim();
        boolean covid = Boolean.parseBoolean(scanner.next().trim());

        if (plec.equals("M")) {
            boolean czyBylWojsko = Boolean.parseBoolean(sth);
            return new Mezczyzna(id, wiek, temperatura, kaszel, covid, czyBylWojsko);
        } else {
            return new Kobieta(id, wiek, temperatura, kaszel, covid, sth);
        }
    }

}
