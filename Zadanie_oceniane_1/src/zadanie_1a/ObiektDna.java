package zadanie_1a;

import java.text.DecimalFormat;

public abstract class ObiektDna extends RandomHolder {
    private double wartosc;

    public ObiektDna(double wartosc) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        this.wartosc = Double.parseDouble(twoDForm.format(wartosc));
    }

    protected int distance() {
        return 1;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }
}
