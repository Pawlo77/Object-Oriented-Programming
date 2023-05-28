package preprocessors;

import models.Kebab;
import models.KebabMeat;
import models.KebabSize;
import models.PlateKebab;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final List<Kebab> fiteredData = new ArrayList<>();

    private static boolean interested(PlateKebab kebab) {
        return kebab.getMeat() == KebabMeat.kurczak && (kebab.getSize() == KebabSize.M | kebab.getSize() == KebabSize.L);
    }
    public void filter(PlateKebab kebab) {
        if (Filter.interested(kebab)) {
            fiteredData.add(kebab);
        }
    }

    public List<Kebab> getFiteredData() {
        return fiteredData;
    }
}
