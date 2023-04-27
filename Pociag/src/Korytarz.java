import java.util.LinkedList;

public class Korytarz {
    private final LinkedList<Pasazer> pasazers;

    public Korytarz() {
        this.pasazers = new LinkedList<>();
    }

    public void addPasazer(Pasazer p) {
        this.pasazers.add(p);
    }

    public void emptyKorytarz() {
        this.pasazers.clear();
    }
}
