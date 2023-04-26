import java.util.HashSet;
import java.util.Set;

public class Terminal<T> {
    private final OperatorBramkiBagazowej operatorBramkiBagazowej;
    private final OperatorBramkiBezpieczenstwa operatorBramkiBezpieczenstwa;
    private final Set<Pasazer> pasazerowie;
    private final T reklama;

    public Terminal(int pasazerNum, T reklama) {
        this.operatorBramkiBagazowej = new OperatorBramkiBagazowej(new BramkaBagazowa());
        this.operatorBramkiBezpieczenstwa = new OperatorBramkiBezpieczenstwa(new BramkaBezpieczenstwa());
        this.pasazerowie = new HashSet<>();
        this.reklama = reklama;

        for (int i = 0; i < pasazerNum; i++)
            pasazerowie.add(new Pasazer());
    }

    public void go() {
        for (Pasazer p : pasazerowie) {
            operatorBramkiBagazowej.sprawdzPasazera(p);
            operatorBramkiBezpieczenstwa.sprawdzPasazera(p);
        }
    }

    public static void main(String[] args) {
        Terminal<Neon> terminal = new Terminal<Neon>(50, new Neon());
        terminal.go();
    }
}
