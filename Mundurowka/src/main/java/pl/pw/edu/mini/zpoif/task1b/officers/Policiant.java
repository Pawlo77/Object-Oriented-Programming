package pl.pw.edu.mini.zpoif.task1b.officers;

import pl.pw.edu.mini.zpoif.task1b.officers.equipment.Equipment;

public class Policiant extends Mundurowy {
    private Radar radar;
    private boolean przeszkolenieRadar;

    @Override
    protected void init() {
        radar = new Radar(this);
        przeszkolenieRadar = r.nextBoolean();
        kolorMunduru = KolorMunduru.niebieski;
    }

    @Override
    protected void doJob() {
        if (r.nextDouble() <= 0.6) {
            radar.checkSpeed();
        } else {
            System.out.println("Bez pomiaru");
        }
    }

    public static class Radar extends Equipment {
        private Policiant policiant;

        public Radar(Policiant policiant) {
            this.policiant = policiant;
        }

        public void checkSpeed() {
            if (!policiant.przeszkolenieRadar) {
                System.out.println("Brak przeszkolenia");
            } else {
                System.out.println(r.nextInt(20, 101));
            }
        }
    }
}
