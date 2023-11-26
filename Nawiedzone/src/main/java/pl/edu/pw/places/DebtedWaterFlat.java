package pl.edu.pw.places;

import pl.edu.pw.goscie.Gosc;
import pl.edu.pw.monsters.Monster;

import java.util.Random;

public class DebtedWaterFlat extends DebtedFlat{
    @Override
    protected void nawiedzLazienke(Gosc gosc) {
        if (new Random().nextBoolean()) {
            nawiedzPralnie(gosc);
        } else {
            nawiedzLazienke(gosc);
        }
    }

    @Override
    protected void nawiedzPralnie(Gosc gosc) {
        new DuchKomornika().nastraszKogos(gosc);
    }

    @Override
    public void nawiedz(Gosc gosc) {
        new DuchPlywaka().nastraszKogos(gosc);
        new DuchPlywaka().nastraszKogos(gosc);
    }

    private class DuchPlywaka implements Monster {
        private void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(new Random().nextInt(21) + 10);
        }
    }
}
