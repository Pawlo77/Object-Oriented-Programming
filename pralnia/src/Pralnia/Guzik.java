package Pralnia;

import java.util.Objects;

public class Guzik extends ElKieszeni {
    private static int idCounter;
    protected final int id;

    public Guzik() {
        this.id = idCounter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guzik guzik = (Guzik) o;
        return id == guzik.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
