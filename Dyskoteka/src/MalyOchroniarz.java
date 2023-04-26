import java.util.Random;

public class MalyOchroniarz {
    private final Sala salaMala;
    private final Sala salaDuza;
    private final Hol hol;
    private final static Random r = new Random();

    public MalyOchroniarz(Sala salaMala, Sala salaDuza, Hol hol) {
        this.salaMala = salaMala;
        this.salaDuza = salaDuza;
        this.hol = hol;
    }

    public boolean check(Uczestnik u) {
        Sala sala;
        if (u.getWiek() >= 18) {
            if (r.nextInt(2) == 0) sala = salaMala;
            else sala = salaDuza;

            try {
                sala.dodajUczestnika(u);
            } catch (SalaPrzepelnionaException e) {
                return false;
            }
            return true;
        }
        return false;
    }
}
