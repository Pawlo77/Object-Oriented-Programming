package obiekty;

import obiekty.ObiektNawodny;

public class Jacht extends ObiektNawodny {
    private final int przedplata;

    public Jacht(String id, String model, String port, float dlugoscGeo, float szerokoscGeo, float cena, int przedplata) {
        super(id, model, port, dlugoscGeo, szerokoscGeo, cena);
        this.przedplata = przedplata;
    }
}
