import models.Kebab;
import models.UnknownMeatException;
import parsers.KebabParser;
import preprocessors.KebabPreprocessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String goodKebab = "../../../resources/kebaby.txt";
        String badKebab = "../../../resources/kebaby_bad.txt";

        List<Kebab> kebabList = new ArrayList<>();
        try {
            kebabList = KebabParser.parseKebabs(goodKebab);
        } catch (IOException | UnknownMeatException e) {
            e.printStackTrace();
        }

        KebabPreprocessor.getSummary(kebabList);
        System.out.println();

        List<Kebab> filteredKebabs = KebabPreprocessor.getSmallTellerKebabs(kebabList);
        KebabPreprocessor.getSummary(filteredKebabs);
        System.out.println();

        try {
            kebabList = KebabParser.parseKebabs(badKebab);
        } catch (IOException | UnknownMeatException e) {
            e.printStackTrace();
        }
    }
}