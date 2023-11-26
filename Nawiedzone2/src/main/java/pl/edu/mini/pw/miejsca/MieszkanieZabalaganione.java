package pl.edu.mini.pw.miejsca;

import pl.edu.mini.pw.ludzie.Wizytor;
import pl.edu.mini.pw.straszaki.Straszak;

public class MieszkanieZabalaganione extends MieszkanieNieSpalone {
    public MieszkanieZabalaganione() {
        super(r.nextInt(25000, 75001));
    }

    @Override
    public void zbadaj(Wizytor wizytor) {
        if (r.nextDouble() <= 0.4) {
            zbadajKuchnie(wizytor);
        } else if (r.nextDouble() <= 0.4) {
            zbadajSalon(wizytor);
        }
    }

    @Override
    protected void zbadajSalon(Wizytor wizytor) {
        class DuchStudenta extends Straszak {
            @Override
            public void nastraszKogos(Wizytor wizytor) {
                if (!wizytor.isKupiec()) {
                    wizytor.nastraszMnie();
                }
            }
        }

        new DuchStudenta().nastraszKogos(wizytor);
        new DuchStudenta().nastraszKogos(wizytor);
        new DuchStudenta().nastraszKogos(wizytor);
        new DuchStudenta().nastraszKogos(wizytor);
    }
}
