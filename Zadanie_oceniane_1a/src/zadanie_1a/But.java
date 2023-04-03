package zadanie_1a;

public class But extends ObiektDna {
    private final static String nazwa = "Kalosz";

    public But() {
        super(0);
    }

    @Override
    public String toString() {
        return "@";
    }

    @Override
    protected int distance() {
        return r.nextInt(2, 4);
    }
}
