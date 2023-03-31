public class Chalkolit extends RadioaktywnyObiektKopalniany {
    public Chalkolit(float wartoscRynkowa) {
        super(wartoscRynkowa);
    }

    @Override
    public double getModifiedMarketValue() {
        return this.wartoscRynkowa;
    }
}
