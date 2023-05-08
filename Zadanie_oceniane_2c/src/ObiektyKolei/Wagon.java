package ObiektyKolei;

import java.util.*;

public class Wagon {
    private List<SortedSet<Podrozny>> podrozni = new LinkedList<>();

    public Wagon() {
        for (int i = 0; i < 8; i++)
            this.podrozni.add(new TreeSet<>());
    }

    public void addPodrozny(Podrozny podrozny) {
        this.podrozni.get(podrozny.getBilet().getNazwaStolika() - 1).add(podrozny);
    }

    public Set<Podrozny> getPasazerowiePrzyStoliku(int nazwa) {
        return this.podrozni.get(nazwa - 1);
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "podrozni=" + podrozni +
                '}';
    }
}
