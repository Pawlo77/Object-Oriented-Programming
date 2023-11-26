package wedliny;

import java.util.function.Supplier;

public class Kielbasa extends Wedlina {
    private StopienUwedzenia stopienUwedzenia;
    private static Supplier<StopienUwedzenia> stopienUwedzeniaGenerator = () -> StopienUwedzenia.values()[r.nextInt(0, StopienUwedzenia.values().length)];

    public Kielbasa() {
        stopienUwedzenia = stopienUwedzeniaGenerator.get();
    }

    public StopienUwedzenia getStopienUwedzenia() {
        return stopienUwedzenia;
    }

    public void setStopienUwedzenia(StopienUwedzenia stopienUwedzenia) {
        this.stopienUwedzenia = stopienUwedzenia;
    }

    public enum StopienUwedzenia {
        maly, sredni, duzy
    }
}
