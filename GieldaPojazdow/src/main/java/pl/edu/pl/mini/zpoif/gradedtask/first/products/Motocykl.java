package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class Motocykl extends ZmotoryzowanyTowar{
    private final byte liczbaMiejsc;

    public Motocykl(double cena, double predkoscMaksymalna, String marka, String model, byte liczbaMiejsc) {
        super(cena, predkoscMaksymalna, marka, model);
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public byte getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    @Override
    public String toString() {
        return "Motocykl{" +
                "liczbaMiejsc=" + liczbaMiejsc +
                ", marka='" + getMarka() + '\'' +
                ", model='" + getModel() + '\'' +
                ", predkoscMaksymalna=" + getPredkoscMaksymalna() +
                ", cena=" + getCena() +
                '}';
    }
}
