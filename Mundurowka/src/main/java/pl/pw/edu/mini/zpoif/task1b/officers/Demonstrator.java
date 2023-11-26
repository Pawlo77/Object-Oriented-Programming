package pl.pw.edu.mini.zpoif.task1b.officers;

import java.util.HashSet;
import java.util.Set;

public class Demonstrator {
    public static void main(String[] args) {
        Policiant policiant = new Policiant();

        Set<Policiant.Radar> radars = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            radars.add(new Policiant.Radar(policiant));
        }
        for (Policiant.Radar radar : radars) {
            radar.checkSpeed();
        }
    }
}
