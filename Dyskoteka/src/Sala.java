import java.util.LinkedHashSet;

public class Sala {
    private final LinkedHashSet<Uczestnik> uczestnicy;
    private final int maxSize;

    public Sala(int maxSize) {
        this.uczestnicy = new LinkedHashSet<>();
        this.maxSize = maxSize;
    }

    public void dodajUczestnika(Uczestnik u) throws SalaPrzepelnionaException {
        if (uczestnicy.size() == maxSize) throw new SalaPrzepelnionaException(this.maxSize);
        this.uczestnicy.add(u);
    }

    public boolean jestNaSali(Uczestnik u) {
        return uczestnicy.contains(u);
    }
}
