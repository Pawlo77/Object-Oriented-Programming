package pl.edu.pw.goscie;

public class Tourist extends Gosc{
    @Override
    public void nastraszMnie(int power) {
        if (power > resistance && !state.equals(State.PANIC)) {
            state = state.equals(State.NORMAL) ? State.SCARED: State.PANIC;
        } else if (power < resistance && !state.equals(State.NORMAL)) {
            state = state.equals(State.PANIC) ? State.SCARED: State.NORMAL;
        }
    }
}
