public class Studentka extends Uczestnik {
    private static int idStudentki;
    public Studentka() {
        super(idStudentki, nextInt(18, 27));
        idStudentki++;
    }
}
