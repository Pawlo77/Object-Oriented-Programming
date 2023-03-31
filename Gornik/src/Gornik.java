public class Gornik {
    float income = 0f;
    ObiektKopalny[][] shaft;

    public Gornik(ObiektKopalny[][] shaft) {
        this.shaft = shaft;
    }

    void goMiner() {
        for (int i = 0; i < this.shaft.length; i++)
            if (this.shaft[i] != null)
                for (int j = 0; j < this.shaft[i].length; j++) {
                    if (this.shaft[i][j] != null) {
                        income += this.shaft[i][j].getModifiedMarketValue();
                        this.shaft[i][j] = null;
                    }
                }
    }
}
