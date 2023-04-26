public class Student extends Uczestnik {
    private static int idStudent;
    public Student() {
        super(idStudent, nextInt(18, 27));
        idStudent++;
    }
}
