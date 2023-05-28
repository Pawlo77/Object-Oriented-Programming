package obiekty;

import java.util.Objects;

public class ObiektNawodny {
    private final String id;
    private final String model;
    private final String port;
    private final float cena;
    private final Lokalizacja lokalizacja;

    public ObiektNawodny(String id, String model, String port, float dlugoscGeo, float szerokoscGeo, float cena) {
        this.id = id;
        this.model = model;
        this.port = port;
        this.lokalizacja = new Lokalizacja(dlugoscGeo, szerokoscGeo);
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObiektNawodny that = (ObiektNawodny) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ObiektNawodny{" +
                "id='" + id + '\'' +
                '}';
    }
}
