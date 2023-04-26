public class DuzyOchroniarz extends MalyOchroniarz {
    private final RejestrObcych rejestr;

    public DuzyOchroniarz(Sala salaMala, Sala salaDuza, Hol hol) {
        super(salaMala, salaDuza, hol);
        this.rejestr = new RejestrObcych();
    }

    @Override
    public boolean check(Uczestnik u) {
        boolean entered = super.check(u);

        if (entered && u instanceof CzlowiekZZewnatrz)
            if (rejestr.canBeAdd((CzlowiekZZewnatrz) u))
                this.rejestr.add((CzlowiekZZewnatrz) u);

        return entered;
    }

    public void printStrangers() {
        System.out.println("Uczestnicy disco z zewnątrz:");
        for (CzlowiekZZewnatrz u : rejestr)
            System.out.println(u);
    }
}
