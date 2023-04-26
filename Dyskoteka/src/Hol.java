import java.util.Iterator;
import java.util.LinkedHashSet;

public class Hol implements Iterable<Uczestnik> {
    private final LinkedHashSet<Uczestnik> uczestnicy;

    public Hol() {
        this.uczestnicy = new LinkedHashSet<>();

        for (int i = 0; i < 33; i++) {
            this.uczestnicy.add(new Student());
            this.uczestnicy.add(new Studentka());
            this.uczestnicy.add(new CzlowiekZZewnatrz());
        }
    }

    @Override
    public Iterator<Uczestnik> iterator() {
        return uczestnicy.iterator();
    }
}
