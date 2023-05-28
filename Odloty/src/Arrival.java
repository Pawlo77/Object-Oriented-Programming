public class Arrival extends Event {
    private final boolean landed;
    private final String origin;
    private final int exitNum;

    @Override
    public void apply(GetArrivals getArrivals) {
        getArrivals.checkArrival(this);
    }

    public Arrival(String hour, String id, String carrier, boolean landed, String origin, int exitNum) {
        super(hour, id, carrier);
        this.landed = landed;
        this.origin = origin;
        this.exitNum = exitNum;
    }

    public boolean isLanded() {
        return landed;
    }

    @Override
    public String toString() {
        return "Arrival{" + super.toString() + ", landed=" + landed + "}";
    }
}
