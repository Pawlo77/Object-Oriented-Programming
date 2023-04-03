import zadanie_1a.Rzeka3;

import javax.naming.directory.InvalidAttributesException;

public class Main {
    public static void main(String[] args) throws InvalidAttributesException {
        Rzeka3 rzeka;

        try {
            rzeka = new Rzeka3(4, 20);
        } catch (InvalidAttributesException e) {
            System.out.println("Tu nie powinno byc bledu");
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < 10; i++) {
            rzeka.moveAll();
            System.out.println();
        }
        System.out.println("Ilosc wywolan: " + rzeka.getIloscWywolan());

//        try {
//            rzeka = new Rzeka3(101, 2);
//        } catch (InvalidAttributesException e) {
//            System.out.println("\nTu powinien byc blad");
//            e.printStackTrace();
//        }
    }
}