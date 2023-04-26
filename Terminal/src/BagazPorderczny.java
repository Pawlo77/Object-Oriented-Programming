import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BagazPorderczny extends Bagaz {
    private static int idPodreczny;
    private final Queue<Przedmiot> przedmioty;

    public BagazPorderczny() {
        super(idPodreczny);
        idPodreczny++;

        this.przedmioty = new LinkedList<>();
        for (int i = 0; i < getNextInt(2, 11); i++)
            this.przedmioty.add(switch (getNextInt(1, 4)) {
                case 1 -> new PrzedmiotLegalny();
                case 2 -> new PrzedmiotNielegalny();
                default -> new Kielbasa();
            });
    }

    public Queue<Przedmiot> pobierzPrzedmiotyZBagazu() {
        return this.przedmioty;
    }
}

