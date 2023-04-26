import java.util.Random;

public class Pracownik {
    private int stazPracy;
    protected static Random r = new Random();

    public Pracownik(int stazPracy) {
        this.stazPracy = stazPracy;
    }
}
