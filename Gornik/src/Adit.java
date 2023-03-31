import java.util.Random;

public class Adit {
    int maxDistance, corridorLen, corridorNum;
    final static Random r = new Random();
    ObiektKopalny[][] shaft;
    Gornik gornik;

    public Adit(int maxDistance, int corridorLen, int corridorNum) {
        this.maxDistance = maxDistance;
        this.corridorLen = corridorLen;
        this.corridorNum = corridorNum;
        this.shaft = new ObiektKopalny[maxDistance * corridorNum + 1][];
        this.gornik = new Gornik(this.shaft);

        int level = -1;
        float what;
        while (corridorNum > 0) {
            corridorNum--;
            level += r.nextInt(1, maxDistance + 2);
            this.shaft[level] = new ObiektKopalny[corridorLen];

            for (int i = 0; i < corridorLen; i++) {
                what = r.nextFloat();

                if (what <= 0.1f)
                    this.shaft[level][i] = new Uranit(50);
                else if (what <= 0.3)
                    this.shaft[level][i] = new Chalkolit(50);
                else
                    this.shaft[level][i] = new Skala();
            }
        }
    }

    void accessPrint(){
        this.printShaft();
    }

    private void printShaft() {
        for (ObiektKopalny[] poziom : this.shaft) {
            if (poziom == null)
                System.out.print(" ");
            else {
                System.out.print("-> ");
                for (ObiektKopalny obiektKopalny : poziom)
                    System.out.print(obiektKopalny + " ");
            }
            System.out.println();
        }
    }
}
