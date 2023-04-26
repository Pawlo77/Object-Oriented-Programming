import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bilet {
    private int rzad;
    private char miejsce;
    private Set<String> usedSpots;
    private static Random r = new Random();

    public Bilet() {
        this.usedSpots = new HashSet<>();
        this.pickRandomSpot();
    }

    private void pickRandomSpot() {
        int rzad = r.nextInt(1, 26);
        char seat = (char) ('A' + r.nextInt(0, 6));
        String spot = String.valueOf(rzad) + "-" + seat;
        if (!usedSpots.contains(spot)) {
            this.rzad = rzad;
            this.miejsce = seat;
            usedSpots.add(spot);
        } else {
            this.pickRandomSpot();
        }
    }

    public int getRzad() {
        return rzad;
    }

    public char getMiejsce() {
        return miejsce;
    }
}
