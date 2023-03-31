import java.util.Random;

public abstract class ObiektKopalny implements MineryObjectEvaluator{
    float wartoscRynkowa;
    final static Random r = new Random();

    public ObiektKopalny(float wartoscRynkowa) {
        this.wartoscRynkowa = wartoscRynkowa;
    }

    @Override
    public String toString() {
        return Float.toString(this.wartoscRynkowa);
    }
}
