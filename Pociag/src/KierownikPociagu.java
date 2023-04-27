import java.util.LinkedHashSet;

public class KierownikPociagu extends Konduktor {
    private final Pociag pociag;

    public KierownikPociagu(Pociag pociag) {
        super(pociag.getWagons());
        this.pociag = pociag;
    }

    public void zaladujPasazerow(LinkedHashSet<Pasazer> pasazerowie) {
        for (Pasazer p : pasazerowie) {
            int idx = nextInt(0, pociag.getWagons().size());
            Wagon w = pociag.getWagons().get(idx);
            System.out.println("Szukam miejsca w wagonie " + idx);
            p.znajdzMiejsce(w);
        }

        int wybrany = nextInt(0, pociag.getKonduktors().size());
        Konduktor[] arr = new Konduktor[pociag.getKonduktors().size()];
        pociag.getKonduktors().toArray(arr);

        boolean sprawdzono = false;
        boolean ruszyla = true;
        while (ruszyla && !sprawdzono) {
            try {
                this.pociag.getLokomotywa().go();
            } catch (LokomotywaStoiException e) {
                ruszyla = false;
                System.out.println("Koniec jazdy!");
                for (Wagon w : pociag.getWagons().values()) {
                    w.emptyKorytarz();
                    for (Przedzial p : w.getPrzedzials())
                        p.emptyPrzedzial();
                }
            }

            if (ruszyla) {
                try {
                    sprawdzono = true;
                    arr[wybrany].sprawdzajBilety();
                } catch (BrakBiletuException e) {
                    sprawdzono = false;
                    pociag.getLokomotywa().stop();
                    Przedzial przedzial = e.getPrzedzial();
                    Pasazer pasazerNaGape = e.getPasazerNaGape();
                    for (int i = 0; i < przedzial.getMiejsca().length; i++)
                        if (przedzial.getMiejsca()[i] == pasazerNaGape) {
                            przedzial.getMiejsca()[i] = null;
                            System.out.println("Usunieto pasazera");
                        }
                }
            }
        }

        if (sprawdzono) {
            pociag.getLokomotywa().stop();
            System.out.println("Koniec podrozy");
            pociag.podsumowanie();
        }
    }
}
