import java.util.Random;

public class RandomHolder {
    private final static Random r = new Random();

    public static int nextInt(int l, int h) {
        return r.nextInt(l, h);
    }
}
