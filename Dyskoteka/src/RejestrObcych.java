import java.util.*;

public class RejestrObcych implements Iterable<CzlowiekZZewnatrz> {
    private final HashMap<String, Set<CzlowiekZZewnatrz>> ludzieZZewnatrz;

    public RejestrObcych() {
        this.ludzieZZewnatrz = new HashMap<>();
    }

    public boolean canBeAdd(CzlowiekZZewnatrz u) {
        return !(ludzieZZewnatrz.containsKey(u.getImie()) && ludzieZZewnatrz.get(u.getImie()).contains(u));
    }

    public void add(CzlowiekZZewnatrz u) {
        if (ludzieZZewnatrz.containsKey(u.getImie())) ludzieZZewnatrz.get(u.getImie()).add(u);
        else {
            ludzieZZewnatrz.put(u.getImie(), new HashSet<>(List.of(u)));
        }
    }

    @Override
    public Iterator<CzlowiekZZewnatrz> iterator() {
        List<CzlowiekZZewnatrz> r = new LinkedList<>();
        for (Set<CzlowiekZZewnatrz> imie : ludzieZZewnatrz.values())
            r.addAll(imie);
        return r.iterator();
    }
}

