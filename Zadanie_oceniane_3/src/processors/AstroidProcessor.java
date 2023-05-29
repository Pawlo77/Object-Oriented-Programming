package processors;

import models.InformacjaOgolna;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AstroidProcessor {
    public static List<InformacjaOgolna> getDangerousAsteroidsOnly(List<InformacjaOgolna> informacjeOAstreoidach) {
        Set<InformacjaOgolna> result = new TreeSet<>();

        if (informacjeOAstreoidach != null) for (InformacjaOgolna informacjaOAstreoidzie : informacjeOAstreoidach)
            if (informacjaOAstreoidzie.isSzczegolowy()) result.add(informacjaOAstreoidzie);

        return new ArrayList<>(result);
    }
}
