public class Uranit extends RadioaktywnyObiektKopalniany {
    Forma forma;

    public Uranit(float wartoscRynkowa) {
        super(wartoscRynkowa);

        int choice = r.nextInt(Forma.values().length);
        this.forma = Forma.values()[choice];
    }

    @Override
    public double getModifiedMarketValue() {
        float scaller = switch (this.forma) {
            case uranofan -> 1.0f;
            case torbernit -> 1.5f;
            case foumarieryt -> 2.5f;
        };
        return this.wartoscRynkowa * scaller;
    }
}
