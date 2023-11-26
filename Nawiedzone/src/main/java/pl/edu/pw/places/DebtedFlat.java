package pl.edu.pw.places;

import pl.edu.pw.goscie.Gosc;
import pl.edu.pw.monsters.Monster;

import java.util.Random;

public abstract class DebtedFlat extends HauntedPlace {
    protected final int kwotaZaleglosci = new Random().nextInt(1001);
    protected abstract void nawiedzLazienke(Gosc gosc);
    protected abstract void nawiedzPralnie(Gosc gosc);

    protected class DuchKomornika implements Monster {
        protected void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(kwotaZaleglosci / 500);
        }
    }
}
