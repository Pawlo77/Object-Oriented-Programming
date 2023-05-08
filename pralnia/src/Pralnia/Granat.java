package Pralnia;

public class Granat extends ElKieszeni {
    protected boolean odbezpieczony;

    public Granat() {
        this.odbezpieczony = r.nextInt(10) == 0;
    }
}
