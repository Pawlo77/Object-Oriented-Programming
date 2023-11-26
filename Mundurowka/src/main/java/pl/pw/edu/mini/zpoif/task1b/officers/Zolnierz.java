package pl.pw.edu.mini.zpoif.task1b.officers;

import pl.pw.edu.mini.zpoif.task1b.officers.equipment.Equipment;

public class Zolnierz extends Mundurowy {
    @Override
    protected void doJob() {
        new Grenadable() {
            @Override
            public void explode() {
            }
        }.explode();
    }

    @Override
    protected void init() {
        kolorMunduru = r.nextBoolean() ? KolorMunduru.stalowy : KolorMunduru.granatowy;

        System.out.println("Zolnierza inicjowac nie trzeba!");
    }

    private interface Grenadable {
        void explode();
    }

    private class granatChalupniczy extends Equipment implements Grenadable {
        @Override
        public void explode() {
            System.out.println("Boom!");
        }
    }
}
