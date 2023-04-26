import java.util.LinkedList;
import java.util.List;

public class BagazGlowny extends Bagaz {
    private static int idGlowny;
    private final List<PrzedmiotLegalny> przedmioty;

    public BagazGlowny() {
        super(idGlowny);
        idGlowny++;

        this.przedmioty = new LinkedList<>();
        for (int i = 0; i < getNextInt(2, 11); i++)
            this.przedmioty.add(new PrzedmiotLegalny());
    }
}
