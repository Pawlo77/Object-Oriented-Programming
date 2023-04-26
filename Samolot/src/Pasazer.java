import java.util.Objects;

public class Pasazer {
    private int id;
    private Bilet bilet;
    private static int idPicker;

    public Pasazer() {
        this.id = idPicker;
        idPicker++;
        this.bilet = new Bilet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasazer pasazer = (Pasazer) o;
        return id == pasazer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Bilet getBilet() {
        return bilet;
    }
}
