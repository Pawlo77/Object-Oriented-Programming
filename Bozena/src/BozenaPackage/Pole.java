package BozenaPackage;

public class Pole extends RandomHolder{
    private Pressing[][] podloze;

    public Pole() {
        this.podloze = new Pressing[100][100];
        for (int i = 0; i < this.podloze.length; i++)
            for (int j = 0; j < this.podloze[i].length; j++) {
                if (r.nextFloat() < 0.4) {
                    this.podloze[i][j] = switch (r.nextInt(4)) {
                        case(1) -> new Trawa();
                        case(2) -> new Purchawka();
                        case(3) -> new MinaPrzeciwczolgowa();
                        default -> new MinaPrzeciwpiechotnia();
                    };
                    if (this.podloze[i][j] instanceof Mina && r.nextFloat() < 0.9)
                        ((Mina) this.podloze[i][j]).armMe();
                }
            }
    }

    public int[] getDim() {
        return new int[] {this.podloze.length, this.podloze[0].length};
    }

    public void deletePodloze(int i, int j) {
        this.podloze[i][j] = null;
    }

    public Pressing getPodloze(int i, int j) {
        return this.podloze[i][j];
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Pressing[] row : this.podloze) {
            for (Pressing entry : row ) {
                if (entry == null)
                    out.append(" ");
                else
                    out.append(entry.toString());
            }
            out.append("\n");
        }
        return out.toString();
    }
}
