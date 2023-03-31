package BozenaPackage;

public class MinaPrzeciwpiechotnia extends Mina implements Pressing {
    Obudowa obudowa;

    public MinaPrzeciwpiechotnia() {
        super();
        this.obudowa = Obudowa.values()[r.nextInt(Obudowa.values().length)];
        if (this.obudowa == Obudowa.karton)
            this.ekologiczna = true;
    }

    @Override
    public String toString() {
        return "x";
    }

    @Override
    public void pressMe() {
        if (this.isUzbrojona())
            System.out.println("Booom!");
        else
            System.out.println("Chrup");
    }
}
