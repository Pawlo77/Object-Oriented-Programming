package ObiektyKolei;

import SystemBiletow.SystemSprzedazyBiletowInterface;

import java.util.*;

public class Podrozny implements Comparable<Podrozny> {
    private final String imie;
    private final int id;
    private final String nazwisko;
    private final int stopienWyglodzenia;
    private final Bilet bilet;
    private final static List<String> imiona = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
    private final static List<String> nazwiska = new ArrayList<>(Arrays.asList("n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "n10"));
    private final static Random r = new Random();
    private static int idCounter;


    public Podrozny(SystemSprzedazyBiletowInterface systemSprzedazy) {
        this.imie = imiona.get(r.nextInt(10));
        this.nazwisko = nazwiska.get(r.nextInt(10));
        this.id = idCounter++;
        this.stopienWyglodzenia = r.nextInt(1, 11);

        this.bilet = systemSprzedazy.sprzedajBilet(imie, nazwisko, Relacja.values()[r.nextInt(2)]);
    }

    // tworzy podroznego z biletem ktorego nikt nie poznaje
    public Podrozny(SystemSprzedazyBiletowInterface systemSprzedazy, boolean kupBilet) {
        this.imie = imiona.get(r.nextInt(10));
        this.nazwisko = nazwiska.get(r.nextInt(10));
        this.id = idCounter++;
        this.stopienWyglodzenia = r.nextInt(1, 11);

        this.bilet = new Bilet(imie, nazwisko, Relacja.WARSZAWA_ZAKOPANE, r.nextInt(1, 9), false);
    }

    public Bilet getBilet() {
        return bilet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Podrozny podrozny = (Podrozny) o;
        return id == podrozny.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Podrozny o) {
        if (this.stopienWyglodzenia == o.stopienWyglodzenia)
            return this.id - o.id;
        return this.stopienWyglodzenia - o.stopienWyglodzenia;
    }

    @Override
    public String toString() {
        return "Podrozny{" +
                ", id=" + id +
                ", stopienWyglodzenia=" + stopienWyglodzenia +
                '}';
    }
}
