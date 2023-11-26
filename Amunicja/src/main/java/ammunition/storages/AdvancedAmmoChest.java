package ammunition.storages;

import ammunition.types.Granat;
import ammunition.types.GranatPrzeciwPancerny;
import ammunition.types.Naboj;

import java.util.concurrent.atomic.AtomicLong;

public class AdvancedAmmoChest extends AmmoChest {

    public void upgradeCaliberToNewOne(Naboj.Kaliber newCaliber) {
        ammunitionChest.forEach(ammo -> {
            if (ammo instanceof Naboj) {
                if (((Naboj) ammo).getKaliber().getVal() > 5.56) {
                    ((Naboj) ammo).setKaliber(newCaliber);
                }
            }
        });
    }

    public void replaceValueToFakePenetrationFactor() {
        boolean newZabezpieczony = AmmoChest.random.nextBoolean();

        ammunitionChest.forEach((ammo) -> {
            if (ammo instanceof Granat) {
                ((Granat) ammo).setZabezpieczony(newZabezpieczony);
            }
        });
    }

    public void getSummarizedCO2Emission() {
        AtomicLong allEmissions = new AtomicLong();

        ammunitionChest.forEach((ammo) -> {
            if (ammo instanceof GranatPrzeciwPancerny) {
                allEmissions.addAndGet(((GranatPrzeciwPancerny) ammo).getEmisjaCO2());
            }
        });

        System.out.println(allEmissions.get());
    }
}
