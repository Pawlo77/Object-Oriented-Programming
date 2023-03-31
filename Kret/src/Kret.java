public class Kret extends ObiektyZiemne implements MoleMotion{
    Gatunek gatunek;
    ObiektyZiemne[][] teren;

    public Kret(Gatunek gatunek, ObiektyZiemne[][] teren) {
        super(0);
        this.wartoscOdzywcza = r.nextInt(200, 241);
        this.teren = teren;
        this.gatunek = gatunek;
    }

    @Override
    public void goMole() {
        int i = r.nextInt(this.teren.length);
        int j = r.nextInt(this.teren[1].length);
        if (this.teren[i][j] != null) {
            this.wartoscOdzywcza += this.teren[i][j].wartoscOdzywcza;
            this.teren[i][j] = null;
            System.out.println("Mniam!");
        }
        else
            System.out.println("Pusto :(");

    }

    @Override
    public String getNutritionalValue() {
        return Integer.toString(this.wartoscOdzywcza);
    }
}
