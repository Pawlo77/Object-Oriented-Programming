import java.util.Objects;

public class Event {
    private final String hour;
    private final String id;
    private final String carrier;

    public Event(String hour, String id, String carrier) {
        this.hour = hour;
        this.id = id;
        this.carrier = carrier;
    }

    public void apply(GetArrivals getArrivals) {
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
