package pl.edu.pw.mini.zpoif.assignments.fourth;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Korweta;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Okret;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretHydrograficzny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretPodwodny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

import java.util.List;
import java.util.Map;

public interface BazaOkretow {
    OkretHydrograficzny method1();

    List<Tralowiec> method2();

    OkretPodwodny method3();

    Korweta method4();

    void method5();

    List<Tralowiec> method6();

    double method7();

    List<String> method8();

    Map<String, Integer> method9();

    List<Okret> method10();
}
