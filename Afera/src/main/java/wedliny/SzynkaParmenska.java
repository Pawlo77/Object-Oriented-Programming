package wedliny;

import java.util.function.Supplier;

public class SzynkaParmenska extends OpakowanaWedlinaBakteria {
    private final Certyfikat certyfikat;
    private static final Supplier<Certyfikat> certyfikatGenerator = () -> Certyfikat.values()[r.nextInt(0, Certyfikat.values().length)];

    public SzynkaParmenska() {
        certyfikat = certyfikatGenerator.get();
    }

    private enum Certyfikat {
        tak, nie, niewiadomo
    }
}
