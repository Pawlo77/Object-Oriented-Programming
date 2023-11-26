package ammunition.storages;

import ammunition.types.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class AmmoChest {
    protected List<Amunicja> ammunitionChest;
    protected final static Random random = new Random();

    public AmmoChest() {
        ammunitionChest = new LinkedList<>();

        // 20 granatow kazdego typu
        for (int i = 0; i < 20; i++) {
            ammunitionChest.add(new GranatObronny());
            ammunitionChest.add(new GranatPrzeciwPancerny());
            ammunitionChest.add(new GranatZaczepny());
        }

        // 2000 nabojow
        for (int i = 0; i < 2000; i++) {
            ammunitionChest.add(new Naboj());
        }
    }

    public List<GranatPrzeciwPancerny> getEcoArmourPiercingGrenades() {
        List<GranatPrzeciwPancerny> result = new LinkedList<>();

        Consumer<Amunicja> lambda = (ammo) -> {
            if (ammo instanceof GranatPrzeciwPancerny) {
                if (((GranatPrzeciwPancerny) ammo).getEmisjaCO2() <= 150) {
                    result.add((GranatPrzeciwPancerny) ammo);
                }
            }
        };

        ammunitionChest.forEach(lambda);
        return result;
    }

    public void printUnlockedGrenades() {
        Consumer<Amunicja> lambda = (ammo) -> {
            if (ammo instanceof GranatPrzeciwPancerny) {
                if (!((Granat) ammo).isZabezpieczony()) {
                    System.out.println("Ooops!");
                }
            }
        };

        ammunitionChest.forEach(lambda);
    }

    public void printSummarizedCaliber() {
        class CaliberSummerizor implements Consumer<Amunicja> {
            private int numNaboj = 0;
            private double totalCaliber = 0;

            @Override
            public void accept(Amunicja ammo) {
                if (ammo instanceof Naboj) {
                    numNaboj++;

                    if (numNaboj > 100 && numNaboj < 201) {
                        totalCaliber += ((Naboj) ammo).getKaliber().getVal();
                    }
                }
            }

            public void printTotalCaliber() {
                System.out.println(totalCaliber);
            }
        }

        CaliberSummerizor caliberSummerizor = new CaliberSummerizor();

        ammunitionChest.forEach(caliberSummerizor);
        caliberSummerizor.printTotalCaliber();
    }

    public void printBulletDetails() {
        Consumer<Amunicja> bulletDetailsPrinter = (ammo) -> {
            if (ammo instanceof Naboj) {
                System.out.println(ammo);
            }
        };

        ammunitionChest.forEach(bulletDetailsPrinter);
    }
}
