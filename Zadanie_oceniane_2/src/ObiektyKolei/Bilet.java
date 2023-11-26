package ObiektyKolei;

import java.util.Objects;

public class Bilet {
    private final String imie;
    private final String nazwisko;
    private final Relacja relacja;
    private final int nazwaStolika;
    private boolean skasowany;
    private final int kodZabezpieczajacy;

    public Bilet(String imie, String nazwisko, Relacja relacja, int nazwaStolika, boolean skasowany) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.relacja = relacja;
        this.nazwaStolika = nazwaStolika;
        this.skasowany = skasowany;
        this.kodZabezpieczajacy = Objects.hash(imie, nazwisko);
    }

    public void setSkasowany(boolean skasowany) {
        this.skasowany = skasowany;
    }

    public int getNazwaStolika() {
        return nazwaStolika;
    }
}
