package zadanie_1a;

import javax.naming.directory.InvalidAttributesException;

public class Rzeka2 extends Rzeka1 {
    private int wywolaniaMoveAll = 0;

    public Rzeka2(int szerokosc, int dlugosc) throws InvalidAttributesException {
        super(szerokosc, dlugosc);
    }

    @Override
    public void moveAll() {
        super.moveAll();
        this.wywolaniaMoveAll++;
    }

    public int getIloscWywolan() {
        return wywolaniaMoveAll;
    }
}
