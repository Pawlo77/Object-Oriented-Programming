import java.util.Random;

public class Gleba extends ObiektyZiemne {
    float gestosc;
    final static float upperBound = 2.4f;
    final static float lowerBound = 1.4f;

    public Gleba(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.gestosc = r.nextFloat() * (upperBound - lowerBound) + lowerBound;
    }

    @Override
    public String toString() {
        return "#";
    }
}
