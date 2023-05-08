package ObiektyKolei;

import Kasowniki.ConnectionLostException;
import Kasowniki.KasownikInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Konduktor {
    private final Map<Podrozny, Bilet> bilety = new HashMap<>();
    private final KasownikInterface kasownik;
    private final Wagon wagon;

    public Konduktor(KasownikInterface kasownik, Wagon wagon) {
        this.kasownik = kasownik;
        this.wagon = wagon;
    }

    public void go() {
        Set<Podrozny> podrozni;
        Iterator<Podrozny> it;
        Podrozny podrozny;
        boolean wazny;

        for (int i = 1; i < 9; i++) {
            podrozni = wagon.getPasazerowiePrzyStoliku(i);
            it = podrozni.iterator();

            while (it.hasNext()) {
                podrozny = it.next();

                // jak kasownik nie dziala to udajemy przed pasazerem ze jest git i idziemy dalej
                wazny = true;

                try {
                    wazny = kasownik.walidujBilet(podrozny.getBilet());
                } catch (ConnectionLostException e) {
                    System.out.println("Kasownik odmowil wspolpracy");
                }

                if (!wazny) {
                    this.bilety.put(podrozny, podrozny.getBilet());
                    it.remove();
                    System.out.println("Wywalilem pasazera " + podrozny);
                }
            }
        }

        System.out.println("Razem wywalilem " + bilety.size() + " osob.");
    }

}
