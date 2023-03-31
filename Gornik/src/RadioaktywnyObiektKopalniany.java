public abstract class RadioaktywnyObiektKopalniany extends  ObiektKopalny {
    int radioaktywnosc;

    public RadioaktywnyObiektKopalniany(float wartoscRynkowa) {
        super(wartoscRynkowa);
        this.radioaktywnosc = r.nextInt(700, 951);
    }
}
