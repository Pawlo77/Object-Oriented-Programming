public class OperatorBramkiBezpieczenstwa implements OperatorBramkiInterface{
    SkanujBagazInterface bramkaBezpieczenstwa;

    public OperatorBramkiBezpieczenstwa(SkanujBagazInterface bramkaBezpieczenstwa) {
        this.bramkaBezpieczenstwa = bramkaBezpieczenstwa;
    }

    @Override
    public void sprawdzPasazera(Pasazer p) {
        int i = 0;
        for (BagazPorderczny b : p.getBagazePodreczne()) {
            boolean legalny = false;
            try {
                legalny = bramkaBezpieczenstwa.skanujBagaz(p, b);
            } catch (KielbasaException e) {
                System.out.println("Kielbasie mówimy stanowcze nie!!!");
            } finally {
                if (!legalny) {
                    System.out.println(p.getBilet().getImie() + " " + p.getBilet().getNazwisko() + " posiadal nielegalny bagaz.");
                    p.usunBagazPodreczny(i);
                }
                i++;
            }
        }
    }
}
