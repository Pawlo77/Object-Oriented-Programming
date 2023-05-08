package Kasowniki;

import ObiektyKolei.Bilet;
import SystemBiletow.SystemSprawdzaniaBiletowInterface;

import java.util.Random;

public class KasownikOnline <T> implements KasownikInterface {
    private static Random r = new Random();
    private SystemSprawdzaniaBiletowInterface systemSprzedazy;
    private final T komunikat;

    public KasownikOnline(SystemSprawdzaniaBiletowInterface systemSprzedazy, T komunikat) {
        this.systemSprzedazy = systemSprzedazy;
        this.komunikat = komunikat;
    }

    public boolean walidujBilet(Bilet bilet) throws ConnectionLostException {
        if (r.nextInt(50) == 0)
            throw new ConnectionLostException();
        boolean wazny = systemSprzedazy.zweryfikujBilet(bilet);

        if (!wazny)
            System.out.println(komunikat);
        return wazny;
    }
}
