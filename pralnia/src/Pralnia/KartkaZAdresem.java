package Pralnia;

import java.util.Objects;

public class KartkaZAdresem extends ElKieszeni {
    protected String ulica;
    protected int nrDomu;

    public KartkaZAdresem(String ulica) {
        this.ulica = ulica;
        this.nrDomu = r.nextInt(1, 223);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KartkaZAdresem that = (KartkaZAdresem) o;
        return nrDomu == that.nrDomu && Objects.equals(ulica, that.ulica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ulica, nrDomu);
    }
}
