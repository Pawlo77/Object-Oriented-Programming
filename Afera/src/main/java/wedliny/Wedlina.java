package wedliny;

import java.util.Random;
import java.util.function.Supplier;

public abstract class Wedlina {
    private final long id;
    private static long idCounter = 0;
    private static final Supplier<Long> idGenerator = () -> idCounter++;
    protected static Random r = new Random();

    public Wedlina() {
        id = idGenerator.get();
    }

    public static void printId(Wedlina w) {
        System.out.println(w.id);
    }

    public long getId() {
        return id;
    }

    public void makeMeReadyForConsumption(Preparator p) {
        p.makeUp(this);
    }

    @FunctionalInterface
    public interface Preparator<T extends Wedlina> {
        void makeUp(T w);
    }
}
