public class MiejsceZajeteException extends Exception {
    @Override
    public String getMessage() {
        return "Miejsce jest już zajęte.";
    }
}
