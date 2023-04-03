package zadanie_1a;

public class ZegarekPodwodny extends ObiektZPolyskiemNumerem {
    private boolean dziala;

    public ZegarekPodwodny() {
        super(r.nextDouble(200, 250), r.nextInt(1, 3) == 1);

        this.dziala = r.nextInt(1, 3) == 1;
    }

    @Override
    public String toString() {
        return "-*-";
    }
}
