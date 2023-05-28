package obiekty;

public class HouseBoat extends RuszajacyObiektNawodny {
    private final boolean poimprezowy;

    public HouseBoat(String id, String model, String port, float dlugoscGeo, float szerokoscGeo, float cena, int mocSilnikow, boolean poimprezowy) {
        super(id, model, port, dlugoscGeo, szerokoscGeo, cena, mocSilnikow);
        this.poimprezowy = poimprezowy;
    }

    public boolean isPoimprezowy() {
        return poimprezowy;
    }
}
