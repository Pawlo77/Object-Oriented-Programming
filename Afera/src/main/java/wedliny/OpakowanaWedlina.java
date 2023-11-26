package wedliny;

import java.time.LocalDate;
import java.util.function.Supplier;

public abstract class OpakowanaWedlina extends Wedlina {
    private LocalDate dataPrzydatnosci;
    private final boolean szczelneOpakowanie;
    private final static Supplier<LocalDate> dataPrzydatnosciGenerator = () -> LocalDate.now().plusDays(r.nextInt(0, 141) - 70);
    private final static Supplier<Boolean> szczelneOpakowanieGenerator = () -> r.nextDouble() < 0.06;

    public OpakowanaWedlina() {
        dataPrzydatnosci = dataPrzydatnosciGenerator.get();
        szczelneOpakowanie = szczelneOpakowanieGenerator.get();
    }

    public LocalDate getDataPrzydatnosci() {
        return dataPrzydatnosci;
    }

    public boolean isPrzeterminowana() {
        return dataPrzydatnosci.isBefore(LocalDate.now());
    }

    public boolean isSzczelneOpakowanie() {
        return szczelneOpakowanie;
    }

    public void setDataPrzydatnosci(LocalDate dataPrzydatnosci) {
        this.dataPrzydatnosci = dataPrzydatnosci;
    }
}
