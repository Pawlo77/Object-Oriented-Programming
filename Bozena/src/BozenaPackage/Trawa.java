package BozenaPackage;

public class Trawa extends Teren implements Pressing{
    public Trawa() {
        this.wysokosc = r.nextFloat(10.5f, 50.5f);
    }

    @Override
    public String toString() {
        return "|";
    }

    @Override
    public void pressMe() {
        System.out.println("Chrup");
    }
}
