import java.util.LinkedList;

public class Pasazer extends RandomHolder {
    private final LinkedList<Bagaz> bagazs;
    private final Bilet bilet;

    public Pasazer(Bilet bilet) {
        this.bilet = bilet;
        this.bagazs = new LinkedList<>();

        for (int i = 0; i < nextInt(1, 4); i++)
            this.bagazs.add(new Bagaz(this));
    }

    public void znajdzMiejsce(Wagon w) {
        int j = 1;
        for (Przedzial p: w.getPrzedzials()) {
            for (int i = 0; i < p.getMiejsca().length; i++)
                if (p.getMiejsca()[i] == null) {
                    p.getMiejsca()[i] = this;
                    p.getPolka().addAll(bagazs);
                    System.out.println("Znalazłem wolne miejsce - przedział " + j + " miejsce " + (i + 1));
                    return;
                }
            j++;
        }
        w.addToKorytarz(this);
        System.out.println("Stoje na korytarzu...");
    }

    public Bilet getBilet() {
        return bilet;
    }
}
