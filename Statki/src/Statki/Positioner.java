package Statki;

public class Positioner extends RandomGen{
    Statek[][] plansza;

    public Positioner(Statek[][] plansza) {
        this.plansza = plansza;
    }

    int[] getPos(boolean nullOnly) {
        int i = r.nextInt(this.plansza.length);
        int j = r.nextInt(this.plansza[0].length);
        if (this.plansza[i][j] == null || !nullOnly)
            return new int[] {i, j};
        return this.getPos(nullOnly);
    }
}

