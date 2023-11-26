package ammunition.types;

import ammunition.suppliers.RandomSupplier;

public abstract class Granat extends Amunicja {
    private static int idCounter = 0;
    private boolean zabezpieczony;

    public Granat() {
        super(idCounter++);
        zabezpieczony = RandomSupplier.provideRandomSafeGenerator(false).get();
    }

    public boolean isZabezpieczony() {
        return zabezpieczony;
    }

    public void setZabezpieczony(boolean zabezpieczony) {
        this.zabezpieczony = zabezpieczony;
    }
}
