package ammunition.types;

import ammunition.suppliers.RandomSupplier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Naboj extends Amunicja {
    private static int idCounter = 0;
    private Kaliber kaliber;

    public Naboj() {
        super(idCounter++);
        kaliber = RandomSupplier.provideRandomCaliberGenerator().get();
    }

    public Kaliber getKaliber() {
        return kaliber;
    }

    public void setKaliber(Kaliber kaliber) {
        this.kaliber = kaliber;
    }

    @Override
    public String toString() {
        return "Naboj{" + "kaliber=" + kaliber + '}';
    }

    public enum Kaliber {
        _5_56(5.56), _7_62(7.62), _9(9), _12_7(12.5);

        private final double val;

        Kaliber(double val) {
            this.val = val;
        }

        public double getVal() {
            return val;
        }

        public static Kaliber getMaxCaliber() {
            List<Kaliber> calibers = new ArrayList<>(List.of(Kaliber.values()));
            calibers.sort(Comparator.comparingDouble(Kaliber::getVal));
            return calibers.get(calibers.size() - 1);
        }
    }
}
