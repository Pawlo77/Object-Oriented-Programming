package BozenaPackage;

public class Bozena extends RandomHolder implements Detonator{
    Pole pole;

    public Bozena(Pole pole) {
        this.pole = pole;
    }

    @Override
    public void destroyMines() {
        int[] dim = this.pole.getDim();
        int i = r.nextInt(dim[0]);

        for (int j = 0; j < dim[1]; j++){
            Pressing poleObject = pole.getPodloze(i, j);
            if (poleObject != null) {
                poleObject.pressMe();
                pole.deletePodloze(i, j);
            }
        }
    }
}
