package pl.edu.mini.pw.miejsca;

import pl.edu.mini.pw.ludzie.Wizytor;
import pl.edu.mini.pw.straszaki.Straszak;

public class MieszkanieZalane extends MieszkanieNieSpalone {
    public MieszkanieZalane() {
        super(r.nextInt(25000, 50001));
    }

    @Override
    public void zbadaj(Wizytor wizytor) {
        if (r.nextBoolean()) {
            zbadajKuchnie(wizytor);
        } else {
            zbadajSalon(wizytor);
        }
    }

    @Override
    protected void zbadajKuchnie(Wizytor wizytor) {
        super.zbadajKuchnie(wizytor);

        new DuchPlywaka().nastraszKogos(wizytor);
    }

    @Override
    protected void zbadajSalon(Wizytor wizytor) {
        super.zbadajSalon(wizytor);
        
        new DuchPlywaka().nastraszKogos(wizytor);
    }

    private class DuchPlywaka extends Straszak {
    }
}
