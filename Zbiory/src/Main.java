import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String goodFilePath = "pacjenci.txt";
        String badFilePath = "pacjenci_bad.txt";

        List<Osoba> osoby = new ArrayList<>();
        try {
            osoby = MyParser.parsePatients(goodFilePath);
        } catch (FileNotFoundException | DublicatedIdException e) {
            e.printStackTrace();
        }

        List<Osoba> kobiety = MyProcessor.getWomanData(osoby);
        List<Osoba> ponizejTemp = MyProcessor.trimData(osoby);

        System.out.println(osoby);
        System.out.println(kobiety);
        System.out.println(ponizejTemp);

        try {
            osoby = MyParser.parsePatients(badFilePath);
        } catch (FileNotFoundException | DublicatedIdException e) {
            e.printStackTrace();
        }
    }
}