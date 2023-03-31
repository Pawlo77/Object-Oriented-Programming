package Grzybnia;

public class MuchomorSzarawy extends GrzybTrujacy{
    private static int rokOdkrycia = 1783;

    public MuchomorSzarawy() {
        super(25, 75, Toksyny.trujace);
    }

    @Override
    protected void ugotuj() {
        super.ugotuj();
        this.toksyny = Toksyny.nieobecne;

    }

    @Override
    protected boolean isTrujacy() {
        return !(this.toksyny == Toksyny.nieobecne);
    }

    @Override
    public String toString() {
        return super.toString() + "rokOdkrycia=" + rokOdkrycia;
    }
}
