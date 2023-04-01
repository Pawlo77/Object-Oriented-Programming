package Statki;

public class Dzialo extends Positioner {
    public Dzialo(Statek[][] plansza) {
        super(plansza);
    }

    void strzel() {
        int[] pos = this.getPos(false);
        if (this.plansza[pos[0]][pos[1]] != null) {
            this.plansza[pos[0]][pos[1]].ostrzal();
            if (this.plansza[pos[0]][pos[1]] != null)
                this.plansza[pos[0]][pos[1]].move();
        }
    }
}
