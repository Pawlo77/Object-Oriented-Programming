package Pralnia;

import java.util.LinkedList;

public class Swiat {
    public void goLive() {
        Pralnia pralnia = new Pralnia(new Certificate());
        LinkedList<Klient> klients = new LinkedList<>();

        for (int i = 0; i < 10; i++)
            klients.add(new Klient(pralnia));
        for (Klient k : klients)
            k.doJob();
    }
}
