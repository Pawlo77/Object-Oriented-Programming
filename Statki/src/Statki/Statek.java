package Statki;

public abstract class Statek extends RandomGen {
    private final String nazwa;
    private static int allShips = 0;
    private final int wytrzymalosc;
    private final int okretNumber;
    private int liczbaTragien;
    private int i;
    private int j;
    private Statek[][] plansza;

    public Statek(String nazwa, int wytrzymalosc, int liczbaTragien, int i, int j, Statek[][] plansza) {
        this.nazwa = nazwa;
        this.wytrzymalosc = wytrzymalosc;
        this.liczbaTragien = liczbaTragien;
        this.i = i;
        this.j = j;
        this.okretNumber = allShips;
        allShips++;
        this.plansza = plansza;
    }

    void ostrzal() {
        this.liczbaTragien++;
        if (liczbaTragien < wytrzymalosc)
            System.out.println(this.nazwa + " zostal trafiony.");
        else {
            System.out.println(this.nazwa + " zostal trafiony i ZATOPIONY.");
            this.plansza[i][j] = null;
        }
    }

    void move() {
        boolean l_allowed = !(i == 0 || plansza[i - 1][j] != null);
        boolean r_allowed = !(i == this.plansza.length - 1 || plansza[i + 1][j] != null);
        boolean d_allowed = !(j == this.plansza[0].length - 1 || plansza[i][j + 1] != null);
        boolean u_allowed = !(j == 0 || plansza[i][j - 1] != null);

        int lr_dir = -1, ud_dir = -1;
        if (l_allowed && r_allowed) lr_dir = r.nextInt(2);
        else if (l_allowed) lr_dir = 1;
        else if (r_allowed) lr_dir = 0;
        if (u_allowed && d_allowed) ud_dir = r.nextInt(2);
        else if (u_allowed) ud_dir = 1;
        else if (d_allowed) ud_dir = 0;

        if (lr_dir == 1) this.i--;
        else if (lr_dir == 0) this.i++;
        if (ud_dir == 1) this.j--;
        else if (ud_dir == 0) this.j++;
    }

    String getSymbol() {
        return "?";
    }
}
