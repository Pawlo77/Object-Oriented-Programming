package Pralnia;

import java.util.LinkedHashSet;

public class Koszula extends UbranieZRozmiarem {
    LinkedHashSet<Guzik> guziki;

    public Koszula() {
        super();

        this.guziki = new LinkedHashSet<>();

        for (int i = 0; i < 6; i++)
            this.guziki.add(new Guzik());

    }
}
