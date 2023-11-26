package pl.pw.edu.mini.zpoif.task1b.officers;

public class Posel extends CzlonekRzadu {
    @Override
    protected void init() {
        legitymacja = new Legitymacja(getShiftedDate(5, false));
    }

    @Override
    protected void checktime() {
        class ControlSmartWatch extends SmartWatch {
            @Override
            protected void printTime() {
                if (legitymacja.isValid()) {
                    super.printTime();
                }
            }
        }

        new ControlSmartWatch().printTime();
    }
}
