package wedliny;

import java.util.function.Supplier;

public abstract class OpakowanaWedlinaBakteria extends OpakowanaWedlina{
    private boolean bakteriaListeria;
    private final static Supplier<Boolean> bakteriaListeriaGenerator = () -> r.nextDouble() < 0.1;

    public OpakowanaWedlinaBakteria() {
        bakteriaListeria = bakteriaListeriaGenerator.get();
    }

    public boolean isBakteriaListeria() {
        return bakteriaListeria;
    }

    public void setBakteriaListeria(boolean bakteriaListeria) {
        this.bakteriaListeria = bakteriaListeria;
    }
}
