import java.util.HashMap;

public class BramkaBagazowa implements ZbadajBagazInterface{
    private final HashMap<Bagaz, Bilet> bagaze;

    public BramkaBagazowa() {
        this.bagaze = new HashMap<>();
    }

    public void zbadajBagaz(Bilet bilet, Bagaz bagaz) {
        this.bagaze.put(bagaz, bilet);
    }
}
