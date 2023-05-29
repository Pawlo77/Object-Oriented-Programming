package models;

import java.util.Objects;

public class InformacjaOgolna implements Comparable<InformacjaOgolna>{
    private final int id;
    private final String nazwa;
    private final Srednica srednica;

    public InformacjaOgolna(int id, String nazwa, Srednica srednica) {
        this.id = id;
        this.nazwa = nazwa;
        this.srednica = srednica;
    }

    protected String getInnerStringRepresentation() {
        return "id=" + id + ", nazwa='" + nazwa + '\'' + ", srednica=" + srednica;
    }

    public int getId() {
        return id;
    }

    public boolean isSzczegolowy() {
        return false;
    }

    @Override
    public String toString() {
        return "models.InformacjaOgolna{" + getInnerStringRepresentation() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacjaOgolna that = (InformacjaOgolna) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(InformacjaOgolna o) {
        return id - o.getId();
    }
}
