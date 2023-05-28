import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightsPreprocessor {
    private List<Event> allFlights;

    public FlightsPreprocessor(List<Event> allFlights) {
        this.allFlights = allFlights;
    }

    public List<Event> getExpectedArrivals() {
        GetArrivals getArrivals = new GetArrivals();

        for (Event event: allFlights) {
            event.apply(getArrivals);
        }

        return getArrivals.getArrivals();
    }

    public List<Event> getFlightsOrdered() {
        List<Event> flights = new ArrayList<>(allFlights);

        Collections.sort(flights, (f1, f2) -> f1.getId().compareTo(f2.getId()));
        return flights;
    }
}
