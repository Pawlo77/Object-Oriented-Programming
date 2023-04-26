import java.util.Stack;

public class Samolot<T> implements PasazerInterface {
    private Pasazer[][] miejsca;
    private Pilot pilot1;
    private Pilot pilot2;
    private Steward[] stewards;
    private Stack<Bagaz> luk;
    private int wagaBagazu;
    private T obiektPrzymusuBezposredniego;

    public Samolot(T obiektPrzymusuBezposredniego) {
        this.miejsca = new Pasazer[25][6];
        this.pilot1 = new Pilot();
        this.pilot2 = new Pilot();
        this.stewards = new Steward[4];
        for (int i = 0; i < 4; i++)
            this.stewards[i] = new Steward();
        this.obiektPrzymusuBezposredniego = obiektPrzymusuBezposredniego;
        this.luk = new Stack<>();
    }

    public int getWagaBagazu() {
        return wagaBagazu;
    }

    public void wstawiaBagaz(Bagaz b) {
        this.wagaBagazu += b.getMasa();
        this.luk.push(b);
    }

    public void boardPassenger(Pasazer p, int rzad, char miejsce) throws MiejsceZajeteException {
        int miejceIdx = (int) miejsce - 64;
        if (this.miejsca[rzad - 1][miejceIdx - 1] == null) this.miejsca[rzad - 1][miejceIdx - 1] = p;
        else throw new MiejsceZajeteException();
    }

    public boolean containsPassenger(Pasazer p) {
        for (Pasazer[] rzad : this.miejsca)
            for (Pasazer podrozny : rzad)
                if (podrozny.equals(p)) return true;
        return false;
    }
}
