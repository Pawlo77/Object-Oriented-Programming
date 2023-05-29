import models.InformacjaOgolna;
import models.SrednicaNieMaSensuException;
import parsers.AstroParser;
import processors.AstroidProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String filePath = "asteroidy.txt";
        List<InformacjaOgolna> informacjeOAstreoidach = new ArrayList<>();

        try {
            informacjeOAstreoidach = AstroParser.parseReliableAsteroidInformation(filePath);
        } catch (SrednicaNieMaSensuException | IOException e) {
            e.printStackTrace();
        }

        List<InformacjaOgolna> informacjeONiebezpiecznychAstreoidach = AstroidProcessor.getDangerousAsteroidsOnly(informacjeOAstreoidach);

        System.out.println();
        System.out.println(informacjeOAstreoidach);
        System.out.println(informacjeONiebezpiecznychAstreoidach);
    }
}