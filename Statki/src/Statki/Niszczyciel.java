package Statki;

public class Niszczyciel extends Statek {
    private static int allDestroyers;
    private final int NiszczycielNumber;
    private int rakiety;

    public Niszczyciel(int i, int j, Statek[][] plansza) {
        super("Niszczyciel " + allDestroyers, 5, 0, i, j, plansza);
        this.NiszczycielNumber = allDestroyers;
        allDestroyers++;
        this.rakiety = r.nextInt(1, 21);
    }

    @Override
    String getSymbol() {
        return "N";
    }
}

