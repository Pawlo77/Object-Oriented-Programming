import java.util.*;

public class Pasazer {
    private final Bilet bilet;
    private SortedSet<BagazGlowny> bagazeGlowne;
    private final LinkedList<BagazPorderczny> bagazePodreczne;
    private static final Random r = new Random();
    private static final Set<Bilet> allBilets = new HashSet<>();

    public Pasazer() {
        this.bilet = this.generateTicket();

        this.bagazeGlowne = new TreeSet<>();
        for (int i = 0; i < r.nextInt(2, 4); i++)
            this.bagazeGlowne.add(new BagazGlowny());
        this.bagazePodreczne = new LinkedList<>();
        for (int i = 0; i < r.nextInt(1, 2); i++)
            this.bagazePodreczne.add(new BagazPorderczny());
    }

    private Bilet generateTicket() {
        int dlugoscImienia = r.nextInt(3, 8);
        int dlugoscNazwiska = r.nextInt(3, 16);

        StringBuilder imieBuffer = new StringBuilder(dlugoscImienia);
        StringBuilder nazwiskoBuffer = new StringBuilder(dlugoscNazwiska);

        for (int i = 0; i < dlugoscImienia; i++)
            imieBuffer.append((char) r.nextInt(97, 123));
        for (int i = 0; i < dlugoscNazwiska; i++)
            nazwiskoBuffer.append((char) r.nextInt(97, 123));

        String imie = imieBuffer.toString();
        String nazwisko = nazwiskoBuffer.toString();
        imie = imie.substring(0, 1).toUpperCase() + imie.substring(1);
        nazwisko = nazwisko.substring(0, 1).toUpperCase() + nazwisko.substring(1);

        Bilet bilet = new Bilet(imie, nazwisko);
        if (!allBilets.contains(bilet)) {
            allBilets.add(bilet);
            return bilet;
        } else {
            return this.generateTicket();
        }
    }

    public SortedSet<BagazGlowny> oddajBagazeGłówne() {
        SortedSet<BagazGlowny> returnValues = bagazeGlowne;
        this.bagazeGlowne = new TreeSet<>();
        return returnValues;
    }

    public LinkedList<BagazPorderczny> getBagazePodreczne() {
        return bagazePodreczne;
    }

    public void usunBagazPodreczny(Integer k) {
        this.bagazePodreczne.remove(k);
    }

    public Bilet getBilet() {
        return bilet;
    }
}
