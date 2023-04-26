import java.util.Objects;
import java.util.Random;

public class Bagaz implements Comparable {
    private int masa;
    private int id;
    private static int idPicker;
    protected static Random r = new Random();

    public Bagaz(int masa) {
        this.masa = masa;
        this.id = idPicker;
        idPicker++;
    }

    public int getMasa() {
        return masa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bagaz bagaz = (Bagaz) o;
        return id == bagaz.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Object o) {
        return masa - ((Bagaz) o).masa;
    }
}
