public class SalaPrzepelnionaException extends Exception {
    public SalaPrzepelnionaException(int maxSize) {
        super("Sala przepelniona - maxSize = " + maxSize);
    }
}
