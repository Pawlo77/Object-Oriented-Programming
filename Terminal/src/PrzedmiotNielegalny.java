import java.util.Random;

public class PrzedmiotNielegalny extends Przedmiot {
    private final int masa;
    private static Random r = new Random();

    public PrzedmiotNielegalny() {
        this.masa = r.nextInt(5, 29);
    }

    public PrzedmiotNielegalny(int lowerBound, int upperBound) {
        this.masa = r.nextInt(lowerBound, upperBound);
    }

    @Override
    public int getStopienNielegalnosci() {
        return this.getMasa() * 10;
    }

    public int getMasa() {
        return masa;
    }
}
