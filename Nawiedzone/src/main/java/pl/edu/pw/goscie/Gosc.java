package pl.edu.pw.goscie;

import java.util.Random;

public abstract class Gosc {
    protected final int resistance;
    protected State state;

    public Gosc() {
        resistance = new Random().nextInt(11) + 10;
        state = State.NORMAL;
    }

    public abstract void nastraszMnie(int power);

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Gosc{" +
                "resistance=" + resistance +
                ", state=" + state +
                '}';
    }
}
