package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class ZmotoryzowanyTowar extends RuszajacyTowar{
    private final String marka;
    private final String model;

    public ZmotoryzowanyTowar(double cena, double predkoscMaksymalna, String marka, String model) {
        super(cena, predkoscMaksymalna);
        this.marka = marka;
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean isOkey() {
        return getMarka().startsWith("S") && getPredkoscMaksymalna()>= 180;
    }

    @Override
    public String toString() {
        return "ZmotoryzowanyTowar{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", predkoscMaksymalna=" + getPredkoscMaksymalna() +
                ", cena=" + getCena() +
                '}';
    }
}
