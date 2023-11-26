import Kasowniki.KasownikInterface;
import Kasowniki.KasownikOffline;
import Kasowniki.KasownikOnline;
import Kasowniki.Komunikat;
import ObiektyKolei.Konduktor;
import ObiektyKolei.Podrozny;
import ObiektyKolei.Wagon;
import SystemBiletow.SystemSprzedazyBiletow;

import java.util.Random;

public class Demonstrator {
    private static Random r = new Random();
    public static void main(String[] args) {
        SystemSprzedazyBiletow systemSprzedazyBiletow = new SystemSprzedazyBiletow();
        Wagon wagon = new Wagon();

        for (int i = 0; i < 48; i++) {
            wagon.addPodrozny(new Podrozny(systemSprzedazyBiletow));
        }
        // dwoch podroznych bez biletow
        wagon.addPodrozny(new Podrozny(systemSprzedazyBiletow, false));
        wagon.addPodrozny(new Podrozny(systemSprzedazyBiletow, false));

        KasownikInterface kasownik;
        if (r.nextInt(2) == 0) {
            kasownik = new KasownikOnline<Komunikat>(systemSprzedazyBiletow, new Komunikat());
        }
        else {
            KasownikOffline kasownikOffline = new KasownikOffline();
            kasownikOffline.wgrajInformacjeOSprzedanychBiletach(systemSprzedazyBiletow.getSprzedaneBilety());
            kasownik = kasownikOffline;
        }

        // brzydka demonstracja ze podrozni przy stolikach sa posortowani po wyglodzeniu
        System.out.println(wagon);
        System.out.println();

        Konduktor konduktor = new Konduktor(kasownik, wagon);
        konduktor.go();
    }
}
