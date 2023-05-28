import java.io.FileNotFoundException;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            List<Event> parsedFlights = FlightsParser.parseFlights("resources/loty.txt");
            FlightsPreprocessor flightsProcessor = new FlightsPreprocessor(parsedFlights);

            System.out.println(flightsProcessor.getExpectedArrivals());
            System.out.println(flightsProcessor.getFlightsOrdered());

            FlightsParser.parseFlights("resources/loty_bad.txt");

        } catch (InvalidDataException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}