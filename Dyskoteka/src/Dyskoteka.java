import java.util.Iterator;
import java.util.Random;

public class Dyskoteka {
    private final Hol hol;
    private final Sala salaMala;
    private final Sala salaDuza;
    private final MalyOchroniarz malyOchroniarz;
    private final DuzyOchroniarz duzyOchroniarz;
    private final static Random r = new Random();

    public Dyskoteka() {
        this.hol = new Hol();
        this.salaMala = new Sala(51);
        this.salaDuza = new Sala(75);
        this.malyOchroniarz = new MalyOchroniarz(this.salaMala, this.salaDuza, this.hol);
        this.duzyOchroniarz = new DuzyOchroniarz(this.salaMala, this.salaDuza, this.hol);
    }

    public static void main(String[] args) {
        Dyskoteka dyskoteka = new Dyskoteka();
        dyskoteka.goLive();
    }

    public void inviteAll() {
        Iterator<Uczestnik> itr = hol.iterator();

        while (itr.hasNext()) {
            Uczestnik u = itr.next();
            System.out.println("Zapraszam " + u);
            boolean entered = (r.nextInt(2) == 1) ? malyOchroniarz.check(u) : duzyOchroniarz.check(u);
            if (entered) itr.remove();
        }

        System.out.println("\nW holu pozostali:");
        for (Uczestnik u : hol)
            System.out.println(u);
        System.out.println();
    }

    public void goLive() {
        inviteAll();
        duzyOchroniarz.printStrangers();
    }
}
