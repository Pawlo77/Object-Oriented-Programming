package zadanie_1a;

public class Butelka extends ObiektDna {
    private Zwrotnosc zwrotna;

    public Butelka() {
        super(0.25);
        this.zwrotna = Zwrotnosc.values()[r.nextInt(Zwrotnosc.values().length)];
        if (this.zwrotna == Zwrotnosc.zwrotna) this.setWartosc(0.5);
    }

    @Override
    public String toString() {
        return "()";
    }

    @Override
    protected int distance() {
        return r.nextInt(2, 5);
    }
}
