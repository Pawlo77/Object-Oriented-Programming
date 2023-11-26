package pl.edu.mini.pw.miejsca;

import pl.edu.mini.pw.ludzie.Kupiec;
import pl.edu.mini.pw.ludzie.Wizytor;
import pl.edu.mini.pw.straszaki.Straszak;

public class MieszkanieSpalone extends Mieszkanie {
    public MieszkanieSpalone() {
        super(r.nextInt(10000, 35001));
    }

    @Override
    public void zbadaj(Wizytor wizytor) {
        new DuchStrazaka(this).nastraszKogos(wizytor);

        new Straszak() {
            @Override
            public void nastraszKogos(Wizytor wizytor) {
                if (wizytor.isKupiec() && (((Kupiec) wizytor).getStan().equals(Kupiec.Stan.CHETNY) || ((Kupiec) wizytor).getStan().equals(Kupiec.Stan.POIRYTOWANY))) {
                    wizytor.nastraszMnie();
                }
            }
        }.nastraszKogos(wizytor);
    }

    public static class DuchStrazaka extends Straszak {
        private Mieszkanie mieszkanie;

        public DuchStrazaka(Mieszkanie mieszkanie) {
            this.mieszkanie = mieszkanie;
        }

        @Override
        public void nastraszKogos(Wizytor wizytor) {
            if (mieszkanie.wartosc < 15000) {
                wizytor.nastraszMnie();
            }
        }
    }
}
