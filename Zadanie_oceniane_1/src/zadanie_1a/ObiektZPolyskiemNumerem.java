package zadanie_1a;

public class ObiektZPolyskiemNumerem extends ObiektZPolyskiem {
    private static int numerWszystkichZegarkow = 10;
    private int numerSeryjny;

    public ObiektZPolyskiemNumerem(double wartosc, boolean polysk) {
        super(wartosc, polysk);

        this.numerSeryjny = numerWszystkichZegarkow;
        numerWszystkichZegarkow++;
    }
}
