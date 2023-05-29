import java.util.ArrayList;
import java.util.List;

public class MyProcessor {
    public static List<Osoba> getWomanData(List<Osoba> osoby) {
        List<Osoba> result = new ArrayList<>();

        if (osoby != null) for (Osoba osoba : osoby)
            if (osoba.isKobieta()) result.add(osoba);

        return result;
    }

    public static List<Osoba> trimData(List<Osoba> osoby) {
        List<Osoba> result = new ArrayList<>();

        if (osoby != null) for (Osoba osoba : osoby)
            if (osoba.getTemperatura() < 36.4) result.add(osoba);

        return result;
    }
}
