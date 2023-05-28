package parsers;

import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KebabParser {

    public static List<Kebab> parseKebabs(String filePath) throws FileNotFoundException, UnknownMeatException {
        String filepath = System.getProperty("java.class.path") + File.separator + filePath;
        System.out.println(filepath);
        Scanner scanner = new Scanner(new File(filepath));
        scanner.useDelimiter("---");
        List<Kebab> res = new ArrayList<>();

        while (scanner.hasNextLine()) {
            res.add(parseKebab(scanner));
            scanner.nextLine();
        }

        return res;
    }

    private static Kebab parseKebab(Scanner scanner) throws  UnknownMeatException {
        KebabSize size = KebabSize.valueOf(scanner.next().trim());
        String sth = scanner.next().trim();

        String meatString = scanner.next().trim();
        KebabMeat meat;
        try {
            meat = KebabMeat.valueOf(meatString);
        } catch (IllegalArgumentException e) {
            throw new UnknownMeatException(meatString);
        }

        double weight = Double.parseDouble(scanner.next().trim());

        KebabAdditives additives;
        try {
            additives = KebabAdditives.valueOf(sth);
        } catch (IllegalArgumentException e) {
            boolean thickCake = Boolean.parseBoolean(sth);
            double price = Double.parseDouble(scanner.next());

            return new CakeKebab(size, weight, meat, price, thickCake);
        }

        boolean takeAway = Boolean.parseBoolean(scanner.next().trim());
        double price = Double.parseDouble(scanner.next());
        return new PlateKebab(size, weight, meat, price, additives, takeAway);
    }
}
