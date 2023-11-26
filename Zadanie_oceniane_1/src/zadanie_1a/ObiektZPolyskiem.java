package zadanie_1a;

public abstract class ObiektZPolyskiem extends ObiektDna {
    private boolean polysk;

    public ObiektZPolyskiem(double wartosc, boolean polysk) {
        super(wartosc);
        this.polysk = polysk;
    }
}
