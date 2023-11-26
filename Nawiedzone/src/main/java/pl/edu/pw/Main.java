package pl.edu.pw;

import pl.edu.pw.goscie.Gosc;
import pl.edu.pw.goscie.Student;
import pl.edu.pw.goscie.Tourist;
import pl.edu.pw.places.*;

import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Gosc> goscs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            goscs.add(new Student());
        }
        for (int i = 0; i < 5; i++) {
            goscs.add(new Tourist());
        }

        List<HauntedPlace> places = new ArrayList<>();
        places.add(new Castle());
        places.add(new Hospital());
        places.add(new DebtedWaterFlat());
        places.add(new DebtedCreditFlat());

        for (Gosc gosc : goscs) {
            System.out.println(gosc);
            for (HauntedPlace place : places) {
                place.nawiedz(gosc);
            }
            System.out.println(gosc);
        }
    }
}