package obiekty;

public class RuszajacyObiektNawodny extends ObiektNawodny {
    private final int mocSilnikow;

    public RuszajacyObiektNawodny(String id, String model, String port, float dlugoscGeo, float szerokoscGeo, float cena, int mocSilnikow) {
        super(id, model, port, dlugoscGeo, szerokoscGeo, cena);
        this.mocSilnikow = mocSilnikow;
    }
}
