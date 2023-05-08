package Pralnia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Ubranie {
    protected static Random r = new Random();
    protected boolean czystosc = false;
    protected Kieszen kieszen;

    public Ubranie() {
        this.kieszen = new Kieszen();

        for (int i = 0; i < r.nextInt(1, 4); i++) {
            ElKieszeni newEl = switch (r.nextInt(3)) {
                case 0 -> new Guzik();
                case 1 -> new KartkaZAdresem("Jakis adres");
                default -> new Granat();
            };
            this.kieszen.elKieszeni.add(newEl);
        }
    }

    public Set<ElKieszeni> oproznijKieszen() {
        Set<ElKieszeni> els = new HashSet<>();
        Iterator<ElKieszeni> it = this.kieszen.elKieszeni.iterator();
        while(it.hasNext()) {
            els.add(it.next());
            it.remove();
        }
        return els;
    }
}
