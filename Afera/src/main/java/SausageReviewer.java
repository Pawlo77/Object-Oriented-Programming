import wedliny.OpakowanaWedlina;
import wedliny.OpakowanaWedlinaBakteria;
import wedliny.Wedlina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

class SausageReviewer {
    private SausageHolder sausageHolder;

    public SausageReviewer(SausageHolder sausageHolder) {
        this.sausageHolder = sausageHolder;
    }

    protected List<OpakowanaWedlinaBakteria> getHamUnfit4Consumption() {
        List r = new ArrayList();

        sausageHolder.getWedlinas().forEach(w -> {
            LocalDate c = LocalDate.now();
            if (w instanceof OpakowanaWedlina) {
                LocalDate d = ((OpakowanaWedlina) w).getDataPrzydatnosci();
                if (d.isAfter(c.minusDays(9)) && d.isBefore(c.minusDays(4))) {
                    r.add(w);
                }
            }
        });

        return r;
    }

    protected void printTheWorstHams() {
        sausageHolder.getWedlinas().forEach(w -> {
            if (w instanceof OpakowanaWedlinaBakteria) {
                OpakowanaWedlinaBakteria w2 = (OpakowanaWedlinaBakteria) w;
                if (w2.isBakteriaListeria() && !w2.isSzczelneOpakowanie() && w2.isPrzeterminowana()) {
                    Wedlina.printId(w2);
                }
            }
        });
    }

    protected void printLessThanAvg() {
        AtomicInteger i = new AtomicInteger();
        AtomicLong sum = new AtomicLong();

        sausageHolder.getWedlinas().forEach(w -> {
            if (i.get() < 10) {
                sum.addAndGet(w.getId());
                i.getAndIncrement();
            } else if (w.getId() < sum.get()){
                Wedlina.printId(w);
            }
        });
    }

    protected OpakowanaWedlinaBakteria getListeriaNegativeAndFitSingleHam() {
//        sausageHolder.getWedlinas().sort((w1, w2) -> (w1.getId() - w2.getId()) < 0 ? -1: 1);

        AtomicLong bestId = new AtomicLong(Long.MAX_VALUE);
        AtomicReference<OpakowanaWedlinaBakteria> best = null;
        sausageHolder.getWedlinas().forEach(w -> {
           if (w instanceof OpakowanaWedlinaBakteria) {
               OpakowanaWedlinaBakteria w2 = (OpakowanaWedlinaBakteria) w;
               if (!w2.isPrzeterminowana() && !w2.isBakteriaListeria() && w2.getId() < bestId.get()) {
                   bestId.set(w2.getId());
                   best.set(w2);
               }
           }
        });

        return best.get();
    }

    public List<Wedlina> getWendlinas() {
        return sausageHolder.getWedlinas();
    }
}
