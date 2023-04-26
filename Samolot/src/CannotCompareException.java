public class CannotCompareException extends Exception {
    @Override
    public String getMessage() {
        return "Bagaz can be only compared with Bagaz";
    }
}
