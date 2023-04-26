public class CzlowiekZZewnatrz extends Uczestnik {
    private static int idZZewnatrz;

    public CzlowiekZZewnatrz() {
        super(idZZewnatrz, nextInt(16, 40));
        idZZewnatrz++;
    }
}
