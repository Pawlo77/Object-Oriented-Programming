import parsery.MyCleverFile;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String goodDataPath = "../my_offers/oferty_czarterowe.txt";
        String badDataPath = "../my_offers/oferty_czarterowe_error.txt";
        String notExistDataPath =  "../my_offers/oferty_czarterowe.html";

        MyCleverFile myCleverFile = new MyCleverFile(notExistDataPath);


    }
}