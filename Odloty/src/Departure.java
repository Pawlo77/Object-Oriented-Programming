

public class Departure extends Event {
    private final Status status;
    private final String dest;
    private final CheckIn checkIn;

    @Override
    public String toString() {
        return "Departure{" + super.toString() + "}";
    }

    public Departure(String hour, String id, String carrier, Status status, String dest, CheckIn checkIn) {
        super(hour, id, carrier);
        this.status = status;
        this.dest = dest;
        this.checkIn = checkIn;
    }
}
