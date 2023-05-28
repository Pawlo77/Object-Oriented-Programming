package preprocessors;

import models.Kebab;

import java.util.List;

public class KebabPreprocessor {

    public static List<Kebab> getSmallTellerKebabs(List<Kebab> kebabList) {
        Filter filter = new Filter();

        for (Kebab kebab: kebabList) {
            kebab.apply(filter);
        }

        return filter.getFiteredData();
    }

    public static void getSummary(List<Kebab> kebabList) {
        double priceSum = 0.;
        double weightSum = 0;

        for (Kebab kebab: kebabList) {
            priceSum += kebab.getPrice();
            weightSum += kebab.getWeight();

            System.out.println(kebab);
        }

        System.out.println("Srednia cena wszystkich dan: " + (priceSum / kebabList.size()));
        System.out.println("Zsumowana waga wszystkich dan: " + weightSum);
    }
}
