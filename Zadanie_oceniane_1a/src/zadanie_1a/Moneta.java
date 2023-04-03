package zadanie_1a;

public class Moneta extends ObiektZPolyskiem {
    public Moneta() {
        // Losujemy wartosc i polysk
        super(r.nextDouble(1, 5000), r.nextInt(1, 3) == 1);
    }

    @Override
    public String toString() {
        return "O";
    }
}
