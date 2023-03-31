import java.util.Random;

public class Environment {
    ObiektyZiemne[][] teren;
    int n, m;
    final static int wartoscOdzywczaDzdzownicy = 3;
    static Random r = new Random();
    MoleMotion kret;

    public Environment(int m, int n, int larwaCount, int dzdzownicaCount) {
        this.teren = new ObiektyZiemne[m][n];
        this.m = m;
        this.n = n;

        this.setTeren(larwaCount, dzdzownicaCount);
    }

    public Environment(int m, int n, int larwaCount, int dzdzownicaCount, Gatunek gatunek) {
        this.teren = new ObiektyZiemne[m][n];
        this.m = m;
        this.n = n;
        this.kret = new Kret(gatunek, this.teren);

        this.setTeren(larwaCount, dzdzownicaCount);
    }

    public void runMole() {
        for (int i = 0; i < 10; i++) {
            this.kret.goMole();
            this.printTeren();
        }
    }

    void setTeren(int larwaCount, int dzdzownicaCount) {
        int[] pos;
        while (larwaCount > 0) {
            larwaCount--;
            pos = this.generatePosition();
            int wartoscOdzywcza = r.nextInt(3, 6);
            this.teren[pos[0]][pos[1]] = new Larwa(wartoscOdzywcza);
        }
        while (dzdzownicaCount > 0) {
            dzdzownicaCount--;
            pos = this.generatePosition();
            this.teren[pos[0]][pos[1]] = new Dzdzownica(wartoscOdzywczaDzdzownicy);
        }

        for (int i = 0; i < this.m; i++)
            for (int j = 0; j < this.n; j++)
                if (this.teren[i][j] == null)
                    this.teren[i][j] = new Gleba(0);
    }

    int[] generatePosition() {
        int i = r.nextInt(this.m);
        int j = r.nextInt(this.n);

        if (this.teren[i][j] == null) {
            return new int[]{i, j};
        }
        return generatePosition();
    }

    public void printTeren() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.teren[i][j] != null)
                    System.out.printf("%3s", this.teren[i][j]);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
