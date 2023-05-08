package Kasowniki;

import ObiektyKolei.Bilet;

public interface KasownikInterface {
    public boolean walidujBilet(Bilet bilet) throws ConnectionLostException;

}
