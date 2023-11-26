package pl.edu.mini.pw;

import pl.edu.mini.pw.ludzie.Kupiec;
import pl.edu.mini.pw.ludzie.Sprzedawca;
import pl.edu.mini.pw.ludzie.Wizytor;
import pl.edu.mini.pw.miejsca.*;

import java.util.ArrayList;
import java.util.List;

public class Demonstrator {
    public static void demonstrate() {
        List<Miejsce> miejsceList = new ArrayList<>();
        miejsceList.add(new MieszkanieSpalone());
        miejsceList.add(new MieszkanieZalane());
        miejsceList.add(new MieszkanieZabalaganione());
        miejsceList.add(new SklepRybka());

        List<Wizytor> wizytorList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wizytorList.add(new Kupiec());
            wizytorList.add(new Sprzedawca());
        }

        for (Wizytor wizytor: wizytorList) {
            for (Miejsce miejsce: miejsceList) {
                miejsce.zbadaj(wizytor);
            }
        }

        MieszkanieSpalone.DuchStrazaka duchStrazaka = new MieszkanieSpalone.DuchStrazaka((Mieszkanie) miejsceList.get(0));
        duchStrazaka.nastraszKogos(wizytorList.get(0));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}
