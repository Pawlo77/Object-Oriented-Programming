package BozenaPackage;

public class MinaPrzeciwczolgowa extends Mina implements Pressing {
    float masaMatWyb;

    public MinaPrzeciwczolgowa() {
        super();
        this.masaMatWyb = r.nextFloat(1.5f, 2.5f);
    }

    @Override
    public String toString() {
        return "X";
    }

    @Override
    public void pressMe() {
        if (this.isUzbrojona())
            System.out.println("Kabooom!");
        else
            System.out.println("Chrup");
    }
}
