package Statki;

public class Fregata extends Statek {
    private static int allFregats;
    private final int FregataNumber, dziala;

    public Fregata(int i, int j, Statek[][] plansza) {
        super("Fregata " + allFregats, 3, 0, i, j, plansza);
        this.FregataNumber = allFregats;
        allFregats++;
        this.dziala = r.nextInt(1, 6);
    }

    @Override
    String getSymbol() {
        return "F";
    }
}
