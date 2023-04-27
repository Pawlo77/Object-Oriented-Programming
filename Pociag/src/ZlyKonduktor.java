import java.util.HashMap;

public class ZlyKonduktor extends Konduktor {
    public ZlyKonduktor(HashMap<Integer, Wagon> wagons) {
        super(wagons);
    }

    @Override
    void sprawdzajBilety() throws BrakBiletuException {
        try {
            super.sprawdzajBilety();
        } catch (BrakBiletuException e) {
            if (e.getPasazerNaGape() instanceof Dorosly || e.getPasazerNaGape() instanceof Student)
                throw e;
            else {
                System.out.println("Non no no, dzieci zostawiam.");
                this.sprawdzajBilety();
            }
        }
    }

    @Override
    public String toString() {
        return "ZlyKonduktor{id=" + getId() + "}";
    }
}
