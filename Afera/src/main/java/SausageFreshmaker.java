import wedliny.Kielbasa;
import wedliny.OpakowanaWedlina;
import wedliny.OpakowanaWedlinaBakteria;
import wedliny.Wedlina;

import java.time.LocalDate;

public class SausageFreshmaker {
    private final SausageReviewer sausageReviewer;

    public SausageFreshmaker(SausageReviewer sausageReviewer) {
        this.sausageReviewer = sausageReviewer;
    }

    public void upgradeHams() {
        Wedlina.Preparator<OpakowanaWedlinaBakteria> lambda = w -> {
            w.setBakteriaListeria(false);
            w.setDataPrzydatnosci(LocalDate.now().plusDays(1));
        };
        sausageReviewer.getHamUnfit4Consumption().forEach(w -> w.makeMeReadyForConsumption(lambda));
    }

    public void upgradeDates() {
        LocalDate d = LocalDate.now().plusDays(10);
        Wedlina.Preparator<Wedlina> lambda = w -> {
            if (w instanceof OpakowanaWedlina) {
                ((OpakowanaWedlina) w).setDataPrzydatnosci(d);
            }
        };
        sausageReviewer.getWendlinas().forEach(w -> w.makeMeReadyForConsumption(lambda));
    }

    public void upgradeSausages() {
        LocalDate d = LocalDate.now().plusDays(10);
        Wedlina.Preparator<Wedlina> lambda = w -> {
            if (w instanceof Kielbasa) {
                Kielbasa w2 = (Kielbasa) w;
                if (w2.getStopienUwedzenia().equals(Kielbasa.StopienUwedzenia.maly)) {
                    w2.setStopienUwedzenia(Kielbasa.StopienUwedzenia.duzy);
                }
            }
        };
        sausageReviewer.getWendlinas().forEach(w -> w.makeMeReadyForConsumption(lambda));
    }
}
