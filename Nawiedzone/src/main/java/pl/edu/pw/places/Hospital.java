package pl.edu.pw.places;

import pl.edu.pw.goscie.Gosc;
import pl.edu.pw.goscie.State;
import pl.edu.pw.monsters.Monster;

public class Hospital extends HauntedPlace {
    @Override
    public void nawiedz(Gosc gosc) {
        new Monster() {
            private void nastraszKogos(Gosc gosc) {
                if (gosc.getState().equals(State.NORMAL)) {
                    gosc.nastraszMnie(15);
                }
            }
        }.nastraszKogos(gosc);
    }
}
