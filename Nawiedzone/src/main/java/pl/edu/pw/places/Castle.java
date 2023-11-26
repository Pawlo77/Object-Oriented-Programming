package pl.edu.pw.places;

import pl.edu.pw.goscie.Gosc;
import pl.edu.pw.monsters.Monster;

public class Castle extends HauntedPlace{
    private final static int mocBialychDam = 20;

    @Override
    public void nawiedz(Gosc gosc) {
        BialaDama dama = new BialaDama();
        dama.nastraszKogos(gosc);

        class DuchWlasciciela implements Monster {
            private void nastraszKogos(Gosc gosc) {
                gosc.nastraszMnie(0);
            }
        }
        DuchWlasciciela d1 = new DuchWlasciciela();
        DuchWlasciciela d2 = new DuchWlasciciela();

        d1.nastraszKogos(gosc);
        d2.nastraszKogos(gosc);
    }

    public class BialaDama implements Monster {
        private void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(mocBialychDam);
        }
    }
}
