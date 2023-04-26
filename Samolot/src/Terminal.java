import java.util.*;

public class Terminal {
    private SortedSet<Bagaz> bagaze;
    private Set<Pasazer> atencjaPasazerow;
    private Queue<Pasazer> kolejka;
    private InzynierZaladunku inzZal;
    private HumanistycznyInzynierZaladunku inzHum;
    private Samolot samolot;

    public <T> Terminal(Samolot<T> samolot) {
        this.samolot = samolot;

        this.bagaze = new TreeSet<>();
        this.atencjaPasazerow = new HashSet<>();
        this.kolejka = new LinkedList<>();

        this.inzZal = new InzynierZaladunku(bagaze, samolot);
        this.inzHum = new HumanistycznyInzynierZaladunku(bagaze, samolot, atencjaPasazerow, kolejka, samolot);
    }

    public <T> void addBagaz(Bagaz b) {
        this.bagaze.add(b);
    }

    public void addPasazer(Pasazer p) {
        if (!atencjaPasazerow.contains(p)) {
            kolejka.add(p);
            atencjaPasazerow.add(p);
        } else {
            System.out.println("Taki ktoś już tu jest.");
        }
    }

    public void zaladuj() {
        this.inzZal.zaladujBagaze();
    }

    public void board() {
        this.inzHum.rozsadzLudzi();
    }

}
