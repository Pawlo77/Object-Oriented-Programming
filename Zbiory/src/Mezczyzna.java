public class Mezczyzna extends Osoba {
    private final boolean czyBylWojsko;

    public Mezczyzna(int id, int wiek, double temperatura, boolean kaszel, boolean covid, boolean czyBylWojsko) {
        super(id, wiek, temperatura, kaszel, covid);
        this.czyBylWojsko = czyBylWojsko;
    }

    @Override
    public String toString() {
        return "Mezczyzna{" + super.toString() + "czyBylWojsko=" + czyBylWojsko + '}';
    }
}
