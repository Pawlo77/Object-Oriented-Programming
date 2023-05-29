package models;

import java.text.DecimalFormat;

public class Srednica {
    private final double min;
    private final double max;
    private final static DecimalFormat df = new DecimalFormat("#.00");

    public Srednica(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "models.Srednica" + "{min=" + df.format(min) + ", max=" + df.format(max) + '}';
    }
}
