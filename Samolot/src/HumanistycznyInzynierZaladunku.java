import java.util.*;

public class HumanistycznyInzynierZaladunku extends InzynierZaladunku {
    private Set<Pasazer> atencjaPasazerow;
    private Queue<Pasazer> kolejka;
    private PasazerInterface objektNaPasazerow;

    public HumanistycznyInzynierZaladunku(SortedSet<Bagaz> bagaze, Samolot samolot, Set<Pasazer> atencjaPasazerow, Queue<Pasazer> kolejka, PasazerInterface objektNaPasazerow) {
        super(bagaze, samolot);
        this.atencjaPasazerow = atencjaPasazerow;
        this.kolejka = kolejka;
        this.objektNaPasazerow = objektNaPasazerow;
    }

    void rozsadzLudzi() {
        Iterator<Pasazer> itr = kolejka.iterator();
        Pasazer p;
        Bilet b;
        boolean success;

        while (itr.hasNext()) {
            p = itr.next();
            b = p.getBilet();

            success = true;
            try {
                objektNaPasazerow.boardPassenger(p, b.getRzad(), b.getMiejsce());
            } catch (MiejsceZajeteException e) {
                System.out.println("Zly bilet - rzad " + b.getRzad() + " miejsce " + b.getMiejsce());
                success = false;
            }

            if (success) {
                itr.remove();
                System.out.println("Ktos usiadl w rzedzie " + b.getRzad() + " miejscu " + b.getMiejsce());
                atencjaPasazerow.remove(p);
            }
        }
    }
}
