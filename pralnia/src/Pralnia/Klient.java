package Pralnia;

public class Klient {
    protected PralniaInterface pralnia;

    public Klient(PralniaInterface pralnia) {
        this.pralnia = pralnia;
    }

    public void doJob() {
        Ubranie u1 = new Koszula();
        Ubranie u2 = new Plaszcz();
        Ubranie u3 = new Kufajka();

        pralnia.putToWash(u1);
        pralnia.putToWash(u2);
        pralnia.putToWash(u3);

        try {
            pralnia.washAll();
        } catch (GranatException e) {
            System.out.println("Znalazlem odbezpieczony granat");
        }

        for (Ubranie u: pralnia.pickUpWashedClothes())
            pralnia.getPocketStuffByClothes(u);
    }

}
