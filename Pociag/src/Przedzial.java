import java.util.Arrays;
import java.util.Stack;

public class Przedzial {
    private final int pojemnosc;
    private Pasazer[] miejsca;
    private Stack<Bagaz> polka;

    public Przedzial(int pojemnosc) {
        this.pojemnosc = pojemnosc;
        this.miejsca = new Pasazer[pojemnosc];
        this.polka = new Stack<>();
    }

    public Pasazer[] getMiejsca() {
        return miejsca;
    }

    public Stack<Bagaz> getPolka() {
        return polka;
    }

    public void emptyPrzedzial() {
        Arrays.fill(this.miejsca, null);
        this.polka.clear();
    }
}
