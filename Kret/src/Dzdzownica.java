public class Dzdzownica extends ZywyObiektZiemny {
    final static float upperBound = 1.0f;
    final static float lowerBound = 0.5f;
    public Dzdzownica(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.masa = r.nextFloat() * (upperBound - lowerBound) + lowerBound;
    }

    @Override
    public String toString() {
        return "{}";
    }
}
