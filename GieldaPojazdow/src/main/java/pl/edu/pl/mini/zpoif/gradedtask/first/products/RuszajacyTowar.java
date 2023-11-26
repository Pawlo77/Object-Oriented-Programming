package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class RuszajacyTowar extends Towar{
    private final double predkoscMaksymalna;

    public RuszajacyTowar(double cena, double predkoscMaksymalna) {
        super(cena);
        this.predkoscMaksymalna = predkoscMaksymalna;
    }

    public double getPredkoscMaksymalna() {
        return predkoscMaksymalna;
    }

    @Override
    public String toString() {
        return "RuszajacyTowar{" +
                "predkoscMaksymalna=" + predkoscMaksymalna +
                ", cena=" + getCena() +
                '}';
    }
}
