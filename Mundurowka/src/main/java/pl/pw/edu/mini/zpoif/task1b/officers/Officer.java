package pl.pw.edu.mini.zpoif.task1b.officers;

import java.util.Random;

public abstract class Officer {
    protected static final String GREETING = "Hello!";
    protected final static Random r = new Random();

    public Officer() {
        init();
    }

    protected abstract void init();
}
