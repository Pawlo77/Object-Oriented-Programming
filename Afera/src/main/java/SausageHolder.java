import wedliny.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SausageHolder {
    private final List<Wedlina> wedlinas;

    public SausageHolder() {
        wedlinas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            wedlinas.add(new Kielbasa());
            wedlinas.add(new SzynkaZwykla());
            wedlinas.add(new SzynkaParmenska());
            wedlinas.add(new Poledwica());
        }
        Collections.shuffle(wedlinas);
    }

    protected List<Wedlina> getWedlinas() {
        return wedlinas;
    }
}
