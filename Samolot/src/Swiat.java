public class Swiat {
    public static void main(String[] args) {
        go();
    }

    static void go() {
        Samolot s = new Samolot<>(new Gazrurka());
        Terminal t = new Terminal(s);

        Pasazer p0 = new Pasazer();
        t.addPasazer(p0);

        for (int i = 0; i < 120 - 1; i++)
            t.addPasazer(new Pasazer());
        for (int i = 0; i < 50; i++) {
            t.addBagaz(new BagazPodreczny());
            t.addBagaz(new BagazGlowny());
        }

        t.addPasazer(p0);

        t.zaladuj();
        t.board();
    }
}
