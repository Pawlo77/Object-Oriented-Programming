package pl.pw.edu.mini.zpoif.task1b.officers;

public abstract class Mundurowy extends Officer {
    protected KolorMunduru kolorMunduru;

    protected abstract void doJob();

    protected enum KolorMunduru {
        niebieski, stalowy, granatowy;
    }
}
