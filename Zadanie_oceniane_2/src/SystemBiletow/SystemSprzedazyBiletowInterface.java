package SystemBiletow;

import ObiektyKolei.Bilet;
import ObiektyKolei.Relacja;

public interface SystemSprzedazyBiletowInterface {
    public Bilet sprzedajBilet(String imie, String nazwisko, Relacja relacjaPociagu);
}
