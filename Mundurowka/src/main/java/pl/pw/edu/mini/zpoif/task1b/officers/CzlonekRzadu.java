package pl.pw.edu.mini.zpoif.task1b.officers;

import pl.pw.edu.mini.zpoif.task1b.officers.equipment.Equipment;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class CzlonekRzadu extends Officer {
    protected Legitymacja legitymacja;

    protected abstract void checktime();

    protected LocalDate getShiftedDate(int by, boolean justBack) {
        LocalDate currDate = LocalDate.now();
        int daysToShift = r.nextInt(1, 1 + by);
        if (r.nextBoolean() || justBack) {
            return currDate.minusDays(daysToShift);
        }
        return currDate.plusDays(daysToShift);
    }

    // W poleceniu 1. zadaniu pojawiala sie zarowno Elektroniczna
    // Legitymacja jak i Legitymacja, stad zrobilem 2
    protected class Legitymacja extends Equipment {
        private LocalDate expiryDate;

        public Legitymacja(LocalDate date) {
            this.expiryDate = date;
        }

        boolean isValid() {
            return expiryDate.isBefore(LocalDate.now());
        }
    }

    protected class SmartWatch extends Equipment {
        protected void printTime() {
            LocalTime currTime = LocalTime.now();
            System.out.println(Officer.GREETING + currTime);
        }
    }
}
