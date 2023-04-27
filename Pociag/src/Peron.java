import java.util.LinkedHashSet;

public class Peron {
    private final LinkedHashSet<Pasazer> pasazers;

    public Peron() {
        this.pasazers = new LinkedHashSet<>();

        for (int i = 0; i < 400; i++)
            this.pasazers.add(new Dorosly(new Bilet()));
        for (int i = 0; i < 50; i++) {
            this.pasazers.add(new Dziecko(new Bilet()));
            this.pasazers.add(new Student(new Bilet()));
        }
    }

    public LinkedHashSet<Pasazer> getPasazers() {
        return pasazers;
    }
}
