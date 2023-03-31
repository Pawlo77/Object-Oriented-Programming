package BozenaPackage;

public abstract class Mina extends RandomHolder {
    private static int idLicznik = 0;
    int id;
    boolean ekologiczna = false;
    boolean uzbrojona = false;

    public Mina() {
        this.id = 10 ^ idLicznik;
        idLicznik++;
    }

    protected void armMe() {
        this.uzbrojona = true;
    }

    protected boolean isUzbrojona() {
        return uzbrojona;
    }
}
