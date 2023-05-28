public class CheckIn {
    private final int startNum;
    private final int endNum;

    public CheckIn(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public String toString() {
        return "Check in stands " + startNum + " to " + endNum;
    }
}
