import java.util.Random;

public abstract class ObiektyZiemne {
    int wartoscOdzywcza;
    static Random r = new Random();
    public ObiektyZiemne(int wartoscOdzywcza) {
        this.wartoscOdzywcza = wartoscOdzywcza;
    }
}
