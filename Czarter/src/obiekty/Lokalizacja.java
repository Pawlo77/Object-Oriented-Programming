package obiekty;

public class Lokalizacja {
    private final float dlugoscGeo;
    private final float szerokoscGeo;

    public Lokalizacja(float dlugoscGeo, float szerokoscGeo) {
        this.dlugoscGeo = dlugoscGeo;
        this.szerokoscGeo = szerokoscGeo;
    }

    @Override
    public String toString() {
        return szerokoscGeo + "N " + dlugoscGeo + "E";
    }
}
