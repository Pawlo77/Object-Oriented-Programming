package Grzybnia;

public abstract class GrzybTrujacy extends Grzyb{
    protected Toksyny toksyny;

    public GrzybTrujacy(Twardosc twardosc, int masaMin, int masaMax, Toksyny toksyny) {
        super(twardosc, masaMin, masaMax);
        this.toksyny = toksyny;
    }

    public GrzybTrujacy(int masaMin, int masaMax, Toksyny toksyny) {
        super(masaMin, masaMax);
        this.toksyny = toksyny;
    }

    @Override
    protected boolean isTrujacy() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "toksyny=" + toksyny;
    }
}
