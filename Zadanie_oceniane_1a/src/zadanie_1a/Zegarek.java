package zadanie_1a;

public class Zegarek extends ObiektZPolyskiemNumerem {
    public Zegarek() {
        super(r.nextDouble(200, 250), r.nextInt(1, 3) == 1);
    }

    @Override
    public String toString() {
        return "*";
    }
}

