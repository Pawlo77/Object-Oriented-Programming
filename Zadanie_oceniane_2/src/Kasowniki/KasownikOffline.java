package Kasowniki;

import ObiektyKolei.Bilet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class KasownikOffline implements KasownikInterface {
    private final List<Bilet> sprzedaneBilety = new LinkedList<>();
    private final Set<Bilet> sprawdzoneBilety = new HashSet<>();

    public boolean walidujBilet(Bilet bilet) {
        if (this.sprzedaneBilety.contains(bilet)) {
            this.sprawdzoneBilety.add(bilet);
            this.sprzedaneBilety.remove(bilet);
            return true;
        }
        return false;
    }

    public void wgrajInformacjeOSprzedanychBiletach(List<Bilet> bilety) {
        this.sprzedaneBilety.addAll(bilety);
    }
}
