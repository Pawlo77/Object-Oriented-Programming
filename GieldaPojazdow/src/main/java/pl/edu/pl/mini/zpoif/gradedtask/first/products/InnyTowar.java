package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class InnyTowar extends Towar{
    private final String opis;

    public InnyTowar(double cena, String opis) {
        super(cena);
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public String toString() {
        return "InnyTowar{" +
                "opis='" + opis + '\'' +
                ", cena=" + getCena() +
                '}';
    }
}
