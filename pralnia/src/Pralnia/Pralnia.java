package Pralnia;

import java.util.*;

public class Pralnia<T> implements PralniaInterface {
    protected Set<Ubranie> przyjete;
    protected Set<Ubranie> wyprane;
    protected Map<Ubranie, LinkedList<ElKieszeni>> rel;
    protected T certyfikat;

    public Pralnia(T certyfikat) {
        this.przyjete = new HashSet<>();
        this.wyprane = new LinkedHashSet<>();
        this.rel = new HashMap<>();
        this.certyfikat = certyfikat;
    }

    public void putToWash(Ubranie u) {
        this.przyjete.add(u);
    }

    public void washAll() throws GranatException {
        Iterator<Ubranie> it = przyjete.iterator();
        Ubranie c;
        Set<ElKieszeni> els;

        while (it.hasNext()) {
            c = it.next();
            els = c.oproznijKieszen();

            this.rel.put(c, new LinkedList<>());
            for (ElKieszeni el : els)
                if (el instanceof Granat && ((Granat) el).odbezpieczony)
                    throw new GranatException();
                else
                    this.rel.get(c).add(el);


            c.czystosc = true;
            this.wyprane.add(c);
            it.remove();
        }
    }

    public Set<Ubranie> pickUpWashedClothes() {
        Iterator<Ubranie> it = wyprane.iterator();
        Set<Ubranie> els = new HashSet<>();

        while (it.hasNext()) {
            els.add(it.next());
            it.remove();
        }
        return els;
    }

    public LinkedList<ElKieszeni> getPocketStuffByClothes(Ubranie u) {
        return this.rel.remove(u);
    }

    public T retrieveCertificate() {
        return certyfikat;
    }
}
