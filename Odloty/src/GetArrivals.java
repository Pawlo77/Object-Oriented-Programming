import java.util.ArrayList;
import java.util.List;

public class GetArrivals {
    private List<Event> arrivals = new ArrayList<>();

    public void checkArrival(Arrival arrival) {
        if (!arrival.isLanded())
            arrivals.add(arrival);
    }

    public List<Event> getArrivals() {
        return new ArrayList<>(arrivals);
    }
}
