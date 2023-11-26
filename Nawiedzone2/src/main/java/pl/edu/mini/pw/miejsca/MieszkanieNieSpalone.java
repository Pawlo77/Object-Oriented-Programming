package pl.edu.mini.pw.miejsca;

import pl.edu.mini.pw.ludzie.Wizytor;
import pl.edu.mini.pw.straszaki.Straszak;

public class MieszkanieNieSpalone extends Mieszkanie {
    protected final static int podatek = 15;

    public MieszkanieNieSpalone(int wartosc) {
        super(wartosc);
    }

    public int getWartoscZpodatkiem() {
        return wartosc + podatek;
    }

    protected void zbadajKuchnie(Wizytor wizytor) {
        class DuchSprzedawcy extends Straszak {
            @Override
            public void nastraszKogos(Wizytor wizytor) {
                wizytor.nastraszMnie();
            }
        }

        if (getWartoscZpodatkiem() > 55000) {
            new DuchSprzedawcy().nastraszKogos(wizytor);
            new DuchSprzedawcy().nastraszKogos(wizytor);
        }
        }

    protected void zbadajSalon(Wizytor wizytor) {
    }
}
