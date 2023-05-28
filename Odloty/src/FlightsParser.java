import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlightsParser {
    public static List<Event> parseFlights(String fileName) throws InvalidDataException, FileNotFoundException {
        List<Event> result = new ArrayList<>();

        String currentWorkingDirectory = System.getProperty("user.dir");
        String filePath = currentWorkingDirectory + File.separator + fileName;

        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter("###");

        while (scanner.hasNextLine()) {
            String flightType = scanner.next();
            if (flightType.equals("O")) {
                result.add(parseDeparture(scanner));
            } else {
                result.add(parseArrival(scanner));
            }
            scanner.nextLine();
        }

        scanner.close();
        return result;
    }

    private static Event parseDeparture(Scanner scanner) throws InvalidDataException {
        String hour = scanner.next();
        String dest = scanner.next();
        String id = scanner.next();
        String carrier = scanner.next();
        Status status = Status.valueOf(scanner.next());

        String[] checkInList = scanner.next().split("-");
        int startNum = Integer.parseInt(checkInList[0]);
        int endNum = Integer.parseInt(checkInList[1]);
        if (startNum > endNum) throw new InvalidDataException("Wrong check in data for flight " + id);
        CheckIn checkIn = new CheckIn(startNum, endNum);

        return new Departure(hour, id, carrier, status, dest, checkIn);
    }

    private static Event parseArrival(Scanner scanner) {
        String hour = scanner.next();
        String origin = scanner.next();
        String id = scanner.next();
        String carrier = scanner.next();
        boolean landed = Boolean.valueOf(scanner.next());
        int exitNum = Integer.parseInt(scanner.next());

        return new Arrival(hour, id, carrier, landed, origin, exitNum);
    }
}
