package pl.edu.pw.places;

import pl.edu.pw.goscie.Gosc;

public class DebtedCreditFlat extends DebtedFlat{
    @Override
    protected void nawiedzLazienke(Gosc gosc) {
        nawiedzLazienke(gosc);
        nawiedzPralnie(gosc);
    }

    @Override
    protected void nawiedzPralnie(Gosc gosc) {
        new DuchKomornika().nastraszKogos(gosc);
        new DuchKomornika().nastraszKogos(gosc);
    }

    @Override
    public void nawiedz(Gosc gosc) {
        new DuchKomornika().nastraszKogos(gosc);

    }
}
