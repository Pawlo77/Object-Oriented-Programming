package ammunition.types;

import ammunition.suppliers.RandomSupplier;

public class GranatPrzeciwPancerny extends Granat {
    private final int emisjaCO2;
    private final byte przebijalnosc;

    public GranatPrzeciwPancerny() {
        emisjaCO2 = RandomSupplier.provideRandomEmissionGenerator(120, 350).get();
        przebijalnosc = RandomSupplier.provideRandomPenetrationLevel().get();
    }

    public int getEmisjaCO2() {
        return emisjaCO2;
    }
}
