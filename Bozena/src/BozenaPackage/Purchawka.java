package BozenaPackage;

public class Purchawka extends Teren implements Pressing{
    public Purchawka() {
        this.wysokosc = r.nextFloat(3.5f, 7.5f);
        this.ekologiczna = r.nextFloat() < 0.5;
    }

    @Override
    public String toString() {
        return "o";
    }

    @Override
    public void pressMe() {
        System.out.println("Puffff");
    }
}
