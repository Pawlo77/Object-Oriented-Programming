package zadanie_1a;

import javax.naming.directory.InvalidAttributesException;

public class Rzeka3 extends Rzeka2{

    public Rzeka3(int szerokosc, int dlugosc) throws InvalidAttributesException {
        super(szerokosc, dlugosc);
    }

    private void pokazRzeke() {
        // dla klarownosci reprezentacji kazda rzecz w tablicy bedzie
        // wyswietlana jako String dlugosci 3, align-right, po nim "|"
        for (ObiektDna[] row : this.getWoda()) {
            for (ObiektDna el : row) {
                if (el != null) System.out.printf("%3s|", el.toString());
                else System.out.print("   |");
            }
            System.out.println();
        }
    }

    @Override
    public void moveAll() {
        super.moveAll();
        this.pokazRzeke();
    }
}
