public class Larwa extends ZywyObiektZiemny {
    final static float upperBound = 3.0f;
    final static float lowerBound = 2.0f;
    public Larwa(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.masa = r.nextFloat() * (upperBound - lowerBound) + lowerBound;
    }

    @Override
    public String toString() {
        return "@";
    }
}
