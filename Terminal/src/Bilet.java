import java.util.Objects;
import java.util.Random;

public class Bilet {
    private final String imie;
    private final String nazwisko;
    private final int nrLoterii;
    private static Random r = new Random();

    public Bilet(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrLoterii = r.nextInt(1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilet bilet = (Bilet) o;
        return Objects.equals(imie, bilet.imie) && Objects.equals(nazwisko, bilet.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
