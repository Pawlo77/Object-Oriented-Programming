import java.util.*;

public class Pociag extends RandomHolder {
    private final LokomotywaInterface lokomotywa;
    private final KierownikPociagu kierownikPociagu;
    private final SortedSet<Konduktor> konduktors;
    private final HashMap<Integer, Wagon> wagons;

    public Pociag() {
        this.lokomotywa = new Lokomotywa();
        this.konduktors = new TreeSet<>();
        this.wagons = new HashMap<>();
        this.kierownikPociagu = new KierownikPociagu(this);

        int liczbaKonduktorowDobrych = nextInt(1, 6);
        int liczbaKonduktorowZlych = nextInt(1, 6);
        int liczbaWagonow = nextInt(5, 16);
        for (int i = 0; i < liczbaKonduktorowZlych; i++)
            this.konduktors.add(new ZlyKonduktor(wagons));
        for (int i = 0; i < liczbaKonduktorowDobrych; i++)
            this.konduktors.add(new DobryKonduktor(wagons));
        for (int i = 0; i < liczbaWagonow; i++)
            this.wagons.put(i, new Wagon());

        System.out.println("Na stacji stoi pociag z " + liczbaWagonow + " wagonami i " + (liczbaKonduktorowDobrych + liczbaKonduktorowZlych)  + " konduktorami.");
        for (Konduktor k: konduktors)
            System.out.println(k);
        System.out.println();
    }

    public KierownikPociagu getKierownikPociagu() {
        return kierownikPociagu;
    }

    public HashMap<Integer, Wagon> getWagons() {
        return wagons;
    }

    public LokomotywaInterface getLokomotywa() {
        return lokomotywa;
    }

    public Set<Konduktor> getKonduktors() {
        return konduktors;
    }

    public static void main(String[] args) {
        Pociag pociag = new Pociag();
        Peron peron = new Peron();
        pociag.getKierownikPociagu().zaladujPasazerow(peron.getPasazers());
    }

    public void podsumowanie() {
        for (Integer i : this.wagons.keySet()) {
            int j = 0;
            for (Przedzial p : this.wagons.get(i).getPrzedzials()) {
                j++;
                int osoby = 0;
                for (Pasazer pp : p.getMiejsca())
                    if (pp != null) osoby++;

                System.out.println("Wagon " + i + " przedzial " + j + " - " + osoby + " pasazerow, " + p.getPolka().size() + " bagazy.");
            }
        }
    }
}
