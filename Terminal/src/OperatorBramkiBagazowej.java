public class OperatorBramkiBagazowej implements OperatorBramkiInterface {
    ZbadajBagazInterface bramkaBagazowa;

    public OperatorBramkiBagazowej(ZbadajBagazInterface bramkaBagazowa) {
        this.bramkaBagazowa = bramkaBagazowa;
    }

    @Override
    public void sprawdzPasazera(Pasazer p) {
        int i = 0;
        for (BagazGlowny b : p.oddajBagazeGłówne()) {
            i++;
            bramkaBagazowa.zbadajBagaz(p.getBilet(), b);
        }
        System.out.println(p.getBilet().getImie() + " " + p.getBilet().getNazwisko() + " Zdal bagaz główny w ilosci: " + i);
    }
}
