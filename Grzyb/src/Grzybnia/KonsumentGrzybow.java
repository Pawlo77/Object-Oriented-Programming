package Grzybnia;

public class KonsumentGrzybow {
    DajGrzyba grzybSupplier;

    public KonsumentGrzybow(DajGrzyba grzybSupplier) {
        this.grzybSupplier = grzybSupplier;
    }

    public void konsumujGrzyby(int n) throws IllegalArgumentException {
        if (n <= 50 || n >= 100)
            throw new IllegalArgumentException("n musi byc z zakresu (50, 100)");

        int[] pozycja;
        Grzyb grzyb;

        for (int i = 0; i < n; i++) {
            pozycja = grzybSupplier.losujPozycje();
            grzyb = grzybSupplier.getGrzyb(pozycja[0], pozycja[1]);

            if (grzyb != null) {
                grzyb.ugotuj();

                if (this.zjedzGrzyba(grzyb))
                    break;
            }
        }
    }

    private boolean zjedzGrzyba(Grzyb grzyb) {
        if (grzyb instanceof GrzybTrujacy) {
            if (((GrzybTrujacy) grzyb).toksyny != Toksyny.nieobecne) {
                System.out.println("Uuuuups!");
                return true;
            }
        }
        return false;
    }
}
