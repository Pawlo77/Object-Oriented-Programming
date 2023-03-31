package Grzybnia;

public class MuchomorSromotnikowy extends GrzybTrujacy {
    public MuchomorSromotnikowy() {
        super(25, 75, null);
        if (this.masaOwocnika < 50)
            this.toksyny = Toksyny.zabojcze;
        else
            this.toksyny = Toksyny.wyjatkowo_zabojcze;
    }
}
