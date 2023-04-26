import java.util.Random;

public class Bagaz implements Comparable{
    private final int id;
    private static Random r = new Random();

    public Bagaz(int id) {
        this.id = id;
    }

    public static int getNextInt(int l, int h) {
        return r.nextInt(l, h);
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        return this.getId() - ((BagazGlowny) o).getId();
    }
}
