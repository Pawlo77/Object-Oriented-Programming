public class Kobieta extends Osoba {
    private final String nazwiskoRodowe;

    public Kobieta(int id, int wiek, double temperatura, boolean kaszel, boolean covid, String nazwiskoRodowe) {
        super(id, wiek, temperatura, kaszel, covid);
        this.nazwiskoRodowe = nazwiskoRodowe;
    }

    @Override
    public boolean isKobieta() {
        return true;
    }

    @Override
    public String toString() {
        return "Kobieta{" + super.toString() + "nazwiskoRodowe='" + nazwiskoRodowe + '\'' + '}';
    }
}
