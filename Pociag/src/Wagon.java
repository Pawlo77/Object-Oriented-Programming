import java.util.LinkedList;

public class Wagon extends RandomHolder {
    private final LinkedList<Przedzial> przedzials;
    private final Korytarz korytarz;

    public Wagon() {
        int przedzialSize = nextInt(0, 2) == 0 ? 6 : 8;
        this.przedzials = new LinkedList<>();
        this.korytarz = new Korytarz();

        for (int i = 0; i < nextInt(6, 11); i++) {
            Przedzial przedzial = new Przedzial(przedzialSize);

            przedzials.add(przedzial);
        }
    }

    public void addToKorytarz(Pasazer p) {
        this.korytarz.addPasazer(p);
    }

    public void emptyKorytarz() {
        this.korytarz.emptyKorytarz();
    }

    public LinkedList<Przedzial> getPrzedzials() {
        return przedzials;
    }
}
