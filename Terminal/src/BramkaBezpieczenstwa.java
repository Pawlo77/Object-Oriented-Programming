import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BramkaBezpieczenstwa implements SkanujBagazInterface {
    private final HashMap<Pasazer, List<PrzedmiotNielegalny>> nielegalnePrzedmioty;

    public BramkaBezpieczenstwa() {
        this.nielegalnePrzedmioty = new HashMap<>();
    }

    public boolean skanujBagaz(Pasazer pasazer, BagazPorderczny bagaz) throws KielbasaException {
        List<PrzedmiotNielegalny> nielegalne = new LinkedList<>();

        for (Przedmiot p : bagaz.pobierzPrzedmiotyZBagazu())
            if (p.getStopienNielegalnosci() > 0) {
                nielegalne.add((PrzedmiotNielegalny) p);
                if (p instanceof Kielbasa) throw new KielbasaException();
                break; // nie wiem mamy przerywac jak znajdziemy jeden a reszte olac
            }

        if (!nielegalne.isEmpty()) {
            if (nielegalnePrzedmioty.containsKey(pasazer)) {
                List<PrzedmiotNielegalny> old = this.nielegalnePrzedmioty.get(pasazer);
                old.addAll(nielegalne);
            } else {
                this.nielegalnePrzedmioty.put(pasazer, nielegalne);
            }
            return false;
        }
        return true;
    }
}
