import java.util.HashMap;
import java.util.Objects;

public class Konduktor extends RandomHolder implements Comparable<Konduktor> {
    private int SprawdzonoBiletow;
    private static int idAll;
    private final int id;

    private final HashMap<Integer, Wagon> wagons;

    public Konduktor(HashMap<Integer, Wagon> wagons) {
        this.wagons = wagons;
        this.id = idAll;
        idAll++;
    }

    void sprawdzajBilety() throws BrakBiletuException {
        int i = -SprawdzonoBiletow;

        for (Wagon w : wagons.values())
            for (Przedzial p : w.getPrzedzials())
                for (Pasazer pp : p.getMiejsca()) {
                    if (pp != null) {
                        Bilet bilet = pp.getBilet();
                        i++;
                        if (i == 20) {
                            SprawdzonoBiletow += 20;
                            throw new BrakBiletuException(p, pp);
                        }
                    }
                }
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Konduktor o) {
        if (this instanceof DobryKonduktor && o instanceof ZlyKonduktor)
            return -1;
        if (this instanceof ZlyKonduktor && o instanceof DobryKonduktor)
            return 1;
        return id - o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Konduktor konduktor = (Konduktor) o;
        return id == konduktor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
