package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class Kon extends RuszajacyTowar{
    private final String imie;
    private final byte wiek;

    public Kon(double cena, double predkoscMaksymalna, String imie, byte wiek) {
        super(cena, predkoscMaksymalna);
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public byte getWiek() {
        return wiek;
    }

    @Override
    public boolean isHorse() {
        return true;
    }

    @Override
    public String toString() {
        return "Kon{" +
                "imie='" + imie + '\'' +
                ", wiek=" + wiek +
                ", predkoscMaksymalna=" + getPredkoscMaksymalna() +
                ", cena=" + getCena() +
                '}';
    }
}
