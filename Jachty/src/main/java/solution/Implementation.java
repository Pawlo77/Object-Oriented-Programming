package solution;

import generator.GeneratorStatkow;
import model.StatekNawodny;
import model.jacht.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Implementation implements Statki {
    private final List<StatekNawodny> statki;

    public Implementation() {
        statki = GeneratorStatkow.generujStatkiNawodne();
    }

    @Override
    public StatekNawodny getNajciezszyStatek() {
        return statki.stream().max(Comparator.comparing(StatekNawodny::getMasa)).get();
    }

    @Override
    public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
        return statki.stream().filter(s -> s.getNazwaProducenta().startsWith("R"))
                     .max(Comparator.comparing(s -> s.getNazwaProducenta().length())).get();
    }

    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return statki.stream().filter(s -> s instanceof JachtMotorowy).map(JachtMotorowy.class::cast)
                     .max(Comparator.comparing(JachtMotorowy::getMocSilnika)).get();
    }

    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return statki.stream().filter(s -> s instanceof JachtKabinowy).map(JachtKabinowy.class::cast)
                     .min(Comparator.comparing(JachtKabinowy::getPowierzchniaZagla)).get();
    }

    @Override
    public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
        return statki.stream().filter(s -> s.getMasa() >= 1400 && s.getDlugosc() > 700).limit(11)
                     .collect(Collectors.toSet());
    }

    @Override
    public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return statki.stream().skip(2).sorted(Comparator.comparing(StatekNawodny::getDlugosc).reversed())
                     .collect(Collectors.toList());
    }

    @Override
    public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
        return statki.stream().filter(s -> s instanceof JachtZaglowy).map(JachtZaglowy.class::cast)
                     .sorted(Comparator.comparing(JachtZaglowy::getPowierzchniaZagla).reversed()).skip(3).limit(8)
                     .collect(Collectors.toList());
    }

    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        statki.stream().filter(s -> s instanceof JachtKabinowy).map(JachtKabinowy.class::cast)
              .filter(s -> s.getZanurzenie() <= 30 && s.getMasa() <= 1300)
              .forEach(s -> s.setKomentarz("Jachtem " + s.getTyp() + " wplyniesz na kazda plycizne!"));
    }

    @Override
    public String get12UnikalnychNazwTypow() {
        return statki.stream().filter(s -> s.getMasa() > 2000 && s instanceof Jacht).skip(3).map(Jacht.class::cast)
                     .map(Jacht::getTyp).distinct().limit(12).collect(Collectors.joining("-"));
    }

    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return statki.stream().filter(s -> s instanceof JachtMotorowy).map(JachtMotorowy.class::cast).collect(
                Collectors.toMap(JachtMotorowy::getTyp, Function.identity(), (existing, replacement) ->
                        existing.getNazwaProducenta().length() < replacement.getNazwaProducenta().length() ?
                                replacement : existing));
    }

    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
        return statki.stream().filter(s -> s instanceof JachtOdkrytopokladowy || s instanceof JachtMotorowy)
                     .map(Jacht.class::cast).filter(s -> s.getNazwaProducenta().equalsIgnoreCase("REGAL"))
                     .sorted(Comparator.comparing(s -> s.getClass().getName()).reversed()).skip(4).limit(4)
                     .collect(Collectors.toList());
    }
}
