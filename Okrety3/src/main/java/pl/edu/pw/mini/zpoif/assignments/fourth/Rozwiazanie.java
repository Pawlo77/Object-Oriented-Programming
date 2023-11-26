package pl.edu.pw.mini.zpoif.assignments.fourth;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.*;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.generator.GeneratorOkretow;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.NiszczycielMin;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.OkretTarczyPrzeciwminowej;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rozwiazanie implements BazaOkretow {
    private final List<Okret> okrets = GeneratorOkretow.generujOkrety();

    @Override
    public OkretHydrograficzny method1() {
        return okrets.stream().filter(o -> o instanceof OkretHydrograficzny).map(OkretHydrograficzny.class::cast)
                     .max(Comparator.comparing(OkretHydrograficzny::getWypornosc)).get();
    }

    @Override
    public List<Tralowiec> method2() {
        return okrets.stream().filter(o -> o instanceof Tralowiec).map(Tralowiec.class::cast)
                     .filter(o -> o.getNazwa().contains("y")).limit(3).collect(Collectors.toList());
    }

    @Override
    public OkretPodwodny method3() {
        return okrets.stream().filter(o -> o instanceof OkretPodwodny).map(OkretPodwodny.class::cast)
                     .filter(o -> !o.isPosiadaMiny()).min(Comparator.comparing(OkretPodwodny::getDlugosc)).orElse(null);
    }

    @Override
    public Korweta method4() {
        return okrets.stream().skip(6).filter(o -> o instanceof Korweta).map(Korweta.class::cast)
                     .filter(o -> o.getMocNapedu() <= 20000).max(Comparator.comparing(Korweta::getLiczbaWyrzutniRakiet))
                     .orElse(null);
    }

    @Override
    public void method5() {
        okrets.stream().filter(o -> o instanceof OkretPodwodny).map(Okret.class::cast).skip(2)
              .filter(o -> o.getZasieg() >= 1000).limit(3).forEach(o -> System.out.println(o.getNazwa().toUpperCase()));
    }

    @Override
    public List<Tralowiec> method6() {
        return okrets.stream().limit(20).skip(9)
                     .filter(o -> o.getWypornosc() <= 500 && o.getDlugosc() >= 40 && o instanceof Tralowiec)
                     .map(Tralowiec.class::cast).skip(1).limit(3).collect(Collectors.toList());
    }

    @Override
    public double method7() {
        return okrets.stream().filter(o -> o instanceof OkretTarczyPrzeciwminowej)
                     .sorted(Comparator.comparing(Okret::getWypornosc)).limit(8).skip(3).map(Okret::getZasieg)
                     .mapToDouble(Integer::doubleValue).average().orElse(Double.NaN);
    }

    @Override
    public List<String> method8() {
        return okrets.stream().filter(o -> o instanceof OkretDesantowy).map(OkretDesantowy.class::cast)
                     .filter(o -> o.getZanurzenie() > 2).map(Okret::getNazwa).limit(5).distinct()
                     .collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> method9() {
        return okrets.stream().filter(o -> o instanceof OkretPodwodny).map(OkretPodwodny.class::cast)
                     .filter(o -> !o.isPosiadaMiny())
                     .sorted(Comparator.comparing(OkretPodwodny::getLiczbaTorped).reversed()).limit(2)
                     .collect(Collectors.toMap(Okret::getNazwa, Okret::getMocNapedu, (old_, new_) -> {
//                         System.out.println("DUBLIKAT");
                         return old_;
                     }));
    }

    @Override
    public List<Okret> method10() {
        int[] i = {0};
        return okrets.stream().filter(o -> (o instanceof Korweta && ((Korweta) o).getLiczbaWyrzutniRakiet() > 2) ||
                             (o instanceof Tralowiec && !((Tralowiec) o).isTralMalomagnetyczny()) ||
                             (o instanceof NiszczycielMin && o.getWypornosc() <= 1000))
                     .sorted((o1, o2) -> o1 instanceof Korweta ? -1 : 0)
                     .filter(o -> !(o instanceof Korweta) || i[0]++ < 4).collect(Collectors.toList());
    }
}
