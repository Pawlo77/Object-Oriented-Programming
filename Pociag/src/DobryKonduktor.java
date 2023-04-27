import java.util.HashMap;

public class DobryKonduktor extends Konduktor {
    public DobryKonduktor(HashMap<Integer, Wagon> wagons) {
        super(wagons);
    }

    @Override
    void sprawdzajBilety() throws BrakBiletuException {
        try {
            super.sprawdzajBilety();
        } catch (BrakBiletuException e) {
            if (e.getPasazerNaGape() instanceof Dorosly)
                throw e;
            else {
                System.out.println("Non no no!");
                this.sprawdzajBilety();
            }
        }
    }

    @Override
    public String toString() {
        return "DobryKonduktor{id=" + getId() + "}";
    }
}
