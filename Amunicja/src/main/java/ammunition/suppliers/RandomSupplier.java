package ammunition.suppliers;

import ammunition.types.Naboj;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier {
    private static final Random r = new Random();
    private static long numCaliberSupplied = 0;

    public static Supplier<Naboj.Kaliber> provideRandomCaliberGenerator() {
        if (numCaliberSupplied > 2000) {
            return Naboj.Kaliber::getMaxCaliber;
        }
        return () -> {
            Naboj.Kaliber[] opt = Naboj.Kaliber.values();
            return opt[r.nextInt(0, opt.length)];
        };
    }

    public static Supplier<Boolean> provideRandomSafeGenerator(boolean alwaysUnlocked) {
        return () -> {
            if (alwaysUnlocked) {
                return false;
            }
            return r.nextDouble() < 0.90;
        };
    }

    public static Supplier<Integer> provideRandomEmissionGenerator(int a, int b) {
        return () -> r.nextInt(a, b + 1);
    }

    public static Supplier<Byte> provideRandomPenetrationLevel() {
        return () -> (byte) r.nextInt(30, 51);
    }
}
