import java.util.*;

public class Uczestnik {
    private final int id;
    private final String imie;
    private final String nazwisko;
    private final int wiek;

    private final static List<String> imiona = new LinkedList<>(Arrays.asList("Jan", "Paweł", "Maciej", "Stas", "Stefan", "Mateusz", "Wiktor", "Marcin", "Krzysztof", "Miłosz"));
    private final static List<String> nazwiska = new LinkedList<>(Arrays.asList("Kowalski", "Mowalski", "Stefarski", "Plotkarski", "Nowak", "Jarosz", "Florek", "Serafin", "Iwaniuk", "Sobocimski"));
    private final static Random r = new Random();

    public Uczestnik(int id, int wiek) {
        this.id = id;
        this.wiek = wiek;
        this.imie = imiona.get(nextInt(0, 10));
        this.nazwisko = nazwiska.get(nextInt(0, 10));
    }

    public static int nextInt(int l, int u) {
        return r.nextInt(l, u);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return id == uczestnik.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Uczestnik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
