import java.util.SortedSet;

public class InzynierZaladunku {
    private SortedSet<Bagaz> bagaze;
    private Samolot samolot;

    public InzynierZaladunku(SortedSet<Bagaz> bagaze, Samolot samolot) {
        this.bagaze = bagaze;
        this.samolot = samolot;
    }

    void zaladujBagaze() {
        while (!bagaze.isEmpty()) {
            samolot.wstawiaBagaz(bagaze.last());
            System.out.println("Wstawiłem bagaż o wadze " + bagaze.last().getMasa());
            bagaze.remove(bagaze.last());
        }
    }
}
