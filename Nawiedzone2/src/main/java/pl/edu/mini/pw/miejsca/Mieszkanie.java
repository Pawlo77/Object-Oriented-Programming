package pl.edu.mini.pw.miejsca;

import java.util.Random;

public class Mieszkanie extends Miejsce {
    protected final int wartosc;
    static final Random r = new Random();

    public Mieszkanie(int wartosc) {
        this.wartosc = wartosc;
    }
}
