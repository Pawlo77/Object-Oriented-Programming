package SystemBiletow;

import ObiektyKolei.Bilet;
import ObiektyKolei.Relacja;

import java.util.*;

public class SystemSprzedazyBiletow implements SystemSprzedazyBiletowInterface, SystemSprawdzaniaBiletowInterface {
    private HashSet<Bilet> sprzedaneBilety = new LinkedHashSet<>();
    private final static Random r = new Random();

    public Bilet sprzedajBilet(String imie, String nazwisko, Relacja relacjaPociagu) {
        Bilet bilet = new Bilet(imie, nazwisko, relacjaPociagu, r.nextInt(1, 9), false);
        this.sprzedaneBilety.add(bilet);
        return bilet;
    }

    public boolean zweryfikujBilet(Bilet bilet) {
        if (this.sprzedaneBilety.contains(bilet)) {
            bilet.setSkasowany(true);
            return true;
        }
        return false;
    }

    public List<Bilet> getSprzedaneBilety() {
        Iterator<Bilet> it = this.sprzedaneBilety.iterator();
        List<Bilet> bilety = new LinkedList<>();
        while (it.hasNext())
            bilety.add(it.next());
        return bilety;
    }
}
