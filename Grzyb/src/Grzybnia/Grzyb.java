package Grzybnia;

import java.util.Random;

public abstract class Grzyb {
    protected Twardosc twardosc;
    protected int masaOwocnika;
    protected static Random r = new Random();

    public Grzyb(int masaMin, int masaMax) {
        this.twardosc = Twardosc.values()[r.nextInt(Twardosc.values().length)];
        this.masaOwocnika = this.rMasa(masaMin, masaMax);
    }
    public Grzyb(Twardosc twardosc, int masaMin, int masaMax) {
        this.twardosc = twardosc;
        this.masaOwocnika = this.rMasa(masaMin, masaMax);
    }

    private int rMasa(int masaMin, int masaMax) {
        return r.nextInt(masaMin, masaMax + 1);
    }

    protected void ugotuj() {
        this.twardosc = Twardosc.miekki;
    }

    protected boolean isTrujacy() {
        return false;
    }

    @Override
    public String toString() {
        return "twardosc=" + twardosc + ", masaOwocnika=" + masaOwocnika;
    }
}
