package pl.pw.edu.mini.zpoif.task1b.officers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Senator extends CzlonekRzadu {
    @Override
    protected void init() {
        class ElektronicznaLegitymacja extends Legitymacja {
            public ElektronicznaLegitymacja(LocalDate date) {
                super(date);
            }
        }

        legitymacja = new ElektronicznaLegitymacja(getShiftedDate(10, true));
    }

    @Override
    protected void checktime() {
        List<SmartWatch> smartWatches = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            smartWatches.add(new SmartWatch());
        }

        smartWatches.get(r.nextInt(smartWatches.size())).printTime();
    }
}
