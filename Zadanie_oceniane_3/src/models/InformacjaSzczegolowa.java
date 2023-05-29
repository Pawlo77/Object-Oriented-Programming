package models;

import models.InformacjaOgolna;

public class InformacjaSzczegolowa extends InformacjaOgolna {
    private final boolean zagrozenieDlaZiemi;
    private final String dataBliskiegoPodejscia;
    private final double predkosc;
    private final double dystans;
    private final ObiektyOrbitowalne orbitujeWokol;
    private final String link;

    public InformacjaSzczegolowa(int id, String nazwa, Srednica srednica, boolean zagrozenieDlaZiemi, String dataBliskiegoPodejscia, double predkosc, double dystans, ObiektyOrbitowalne orbitujeWokol, String link) {
        super(id, nazwa, srednica);
        this.zagrozenieDlaZiemi = zagrozenieDlaZiemi;
        this.dataBliskiegoPodejscia = dataBliskiegoPodejscia;
        this.predkosc = Math.round(predkosc * 10.0) / 10.0;
        this.dystans = Math.round(predkosc * 10.0) / 10.0;
        this.orbitujeWokol = orbitujeWokol;
        this.link = link;
    }

    @Override
    public boolean isSzczegolowy() {
        return true;
    }

    @Override
    public String toString() {
        return "models.InformacjaSzczegolowa{" + super.getInnerStringRepresentation() + ", zagrozenieDlaZiemi=" + zagrozenieDlaZiemi + ", dataBliskiegoPodejscia='" + dataBliskiegoPodejscia + '\'' + ", predkosc=" + predkosc + ", dystans=" + dystans + ", orbitujeWokol=" + orbitujeWokol + ", link='" + link + '\'' + '}';
    }
}
