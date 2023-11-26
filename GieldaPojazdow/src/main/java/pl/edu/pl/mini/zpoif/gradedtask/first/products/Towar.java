package pl.edu.pl.mini.zpoif.gradedtask.first.products;

public class Towar implements Comparable<Towar> {
    private final double cena;

    public Towar(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public boolean isOkey() {
        return false;
    }

    public boolean isHorse() {
        return false;
    }

    @Override
    public String toString() {
        return "Towar{" +
                "cena=" + cena +
                '}';
    }

    @Override
    public int compareTo(Towar o) {
        return (int)(cena - o.getCena());
    }
}
