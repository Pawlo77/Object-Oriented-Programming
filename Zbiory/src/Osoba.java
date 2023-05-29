import java.util.Objects;

public class Osoba {
    private final int id;
    private final int wiek;
    private final double temperatura;
    private final boolean kaszel;
    private final boolean covid;

    public Osoba(int id, int wiek, double temperatura, boolean kaszel, boolean covid) {
        this.id = id;
        this.wiek = wiek;
        this.temperatura = temperatura;
        this.kaszel = kaszel;
        this.covid = covid;
    }

    public boolean isKobieta() {
        return false;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return id == osoba.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id=" + id + ", wiek=" + wiek + ", temperatura=" + temperatura + ", kaszel=" + kaszel + ", covid=" + covid;
    }
}
