package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class Samochod extends ZmotoryzowanyTowar{
    private final boolean bezwypadkowy;

    public Samochod(double cena, double predkoscMaksymalna, String marka, String model, boolean bezwypadkowy) {
        super(cena, predkoscMaksymalna, marka, model);
        this.bezwypadkowy = bezwypadkowy;
    }

    public boolean isBezwypadkowy() {
        return bezwypadkowy;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "bezwypadkowy=" + bezwypadkowy +
                ", marka='" + getMarka() + '\'' +
                ", model='" + getModel() + '\'' +
                ", predkoscMaksymalna=" + getPredkoscMaksymalna() +
                ", cena=" + getCena() +
                '}';
    }
}
