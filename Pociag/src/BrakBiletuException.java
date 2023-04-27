public class BrakBiletuException extends Exception {
    private final Przedzial przedzial;
    private final Pasazer pasazerNaGape;

    public BrakBiletuException(Przedzial przedzial, Pasazer pasazerNaGape) {
        this.przedzial = przedzial;
        this.pasazerNaGape = pasazerNaGape;
    }

    public Przedzial getPrzedzial() {
        return przedzial;
    }

    public Pasazer getPasazerNaGape() {
        return pasazerNaGape;
    }
}
