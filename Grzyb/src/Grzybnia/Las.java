package Grzybnia;

import java.util.Random;

public class Las implements DajGrzyba{
    private Grzyb[][] las;
    private static Random r = new Random();

    public Las(int x, int y) {
        x = x <= 0 ? 100: x;
        y = y <= 0 ? 100: y;
        this.las = new Grzyb[x][y];

        int forbiddenColumn = r.nextInt(y);

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                if (j != forbiddenColumn && r.nextFloat() <= 0.2)
                    this.las[i][j] = switch (r.nextInt(1, 5)) {
                        case (1) -> new MuchomorCesarski();
                        case (2) -> new MuchomorKolczastoglowy();
                        case (3) -> new MuchomorSromotnikowy();
                        default -> new MuchomorSzarawy();
                    };
    }

    @Override
    public Grzyb getGrzyb(int i, int j) {
        Grzyb grzyb = this.las[i][j];
        this.las[i][j] = null;
        return grzyb;
    }

    @Override
    public int[] losujPozycje() {
        int i = r.nextInt(this.las.length);
        int j = r.nextInt(this.las[0].length);
        return new int[] {i, j};
    }
}
