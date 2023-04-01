package Statki;

public class Gra extends Positioner implements Graing {
    private final Dzialo dzialo;

    public Gra(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        super(new Statek[100][100]);
        this.dzialo = new Dzialo(this.plansza);
        this.initcjalizuj(liczbaNiszczycieli, liczbaFregat, liczbaKorwet);
    }

    public Gra() {
        super(new Statek[100][100]);
        this.dzialo = new Dzialo(this.plansza);
        this.initcjalizuj(100, 500, 1000);
    }

    private void initcjalizuj(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        int[] pos;
        while (liczbaNiszczycieli > 0) {
            liczbaNiszczycieli--;
            pos = this.getPos(true);
            this.plansza[pos[0]][pos[1]] = new Niszczyciel(pos[0], pos[1], this.plansza);
        }
        while (liczbaFregat > 0) {
            liczbaFregat--;
            pos = this.getPos(true);
            this.plansza[pos[0]][pos[1]] = new Fregata(pos[0], pos[1], this.plansza);
        }
        while (liczbaKorwet > 0) {
            liczbaKorwet--;
            pos = this.getPos(true);
            this.plansza[pos[0]][pos[1]] = new Korweta(pos[0], pos[1], this.plansza);
        }
    }

    @Override
    public void graj(int liczbaTur) {
        for (int i = 1; i <= liczbaTur; i++) {
            System.out.println("Tura " + i);
            for (int j = 0; j < 10; j++)
                this.dzialo.strzel();
        }
    }

    @Override
    public void pokazPlansze() {
        for (Statek[] row: this.plansza) {
            for (Statek entry : row) {
                if (entry == null)
                    System.out.print("~");
                else
                    System.out.print(entry.getSymbol());
            }
            System.out.println();
        }
    }
}
