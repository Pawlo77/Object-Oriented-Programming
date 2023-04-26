public class Kielbasa extends PrzedmiotNielegalny {
    public Kielbasa() {
        super(1, 3);
    }

    @Override
    public int getStopienNielegalnosci() {
        return this.getMasa() * 5;
    }
}
