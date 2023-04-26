public class Pilot extends Pracownik {
    private int nalot;

    public Pilot() {
        super(r.nextInt(5, 21));
        this.nalot = r.nextInt(2000, 5001);
    }
}
