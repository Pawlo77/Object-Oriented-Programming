package Statki;

public class Korweta extends Statek {
    private static int allCorvetas;
    private final int KorwetaNumber, minyGlebinowe;

    public Korweta(int i, int j, Statek[][] plansza) {
        super("Korweta " + allCorvetas, 1, 0, i, j, plansza);
        this.KorwetaNumber = allCorvetas;
        allCorvetas++;
        this.minyGlebinowe = r.nextInt(1, 4);
    }

    @Override
    String getSymbol() {
        return "K";
    }
}
