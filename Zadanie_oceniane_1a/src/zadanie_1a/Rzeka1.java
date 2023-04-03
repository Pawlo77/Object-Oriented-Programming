package zadanie_1a;

import javax.naming.directory.InvalidAttributesException;

public class Rzeka1 extends RandomHolder {
    private ObiektDna[][] woda;

    public Rzeka1(int szerokosc, int dlugosc) throws InvalidAttributesException {
        if (!(1 <= szerokosc && szerokosc <= 100) || !(1 <= dlugosc && dlugosc <= 100))
            throw new InvalidAttributesException("Szerokosc i dlugosc muszą byc z przedziału <1, 100>");

        this.woda = new ObiektDna[szerokosc][dlugosc];
        for (int i = 0; i < szerokosc; i++)
            for (int j = 0; j < dlugosc; j++)
                if (r.nextInt(11) == 0) this.woda[i][j] = switch (r.nextInt(5)) {
                    case (0) -> new Moneta();
                    case (1) -> new Zegarek();
                    case (2) -> new ZegarekPodwodny();
                    case (3) -> new But();
                    default -> new Butelka();
                };
    }

    public void moveAll() {
        int by;

        // implementacja bezposrednio z polecenia -
        for (int i = 0; i < woda.length; i++)
            for (int j = 0; j < woda[i].length; j++)
                if (woda[i][j] != null) {
                    by = woda[i][j].distance();
                    if (j + by < woda[i].length) {
                        if (woda[i][j + by] == null) {
                            this.woda[i][j + by] = woda[i][j];
                            this.woda[i][j] = null;
                        }
                    } else {
                        this.woda[i][j] = null;
                    }
                }
    }

    protected ObiektDna[][] getWoda() {
        return woda;
    }
}
