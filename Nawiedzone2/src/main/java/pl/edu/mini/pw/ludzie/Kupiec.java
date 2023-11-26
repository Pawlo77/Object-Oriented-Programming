package pl.edu.mini.pw.ludzie;

public class Kupiec extends Wizytor {
    private Stan stan = Stan.CHETNY;
    private int przestraszonyNum = 0;

    @Override
    public void nastraszMnie() {
        przestraszonyNum++;

        if (przestraszonyNum > 10 && !stan.equals(Stan.ZNIECHECONY)) {
            stan = Stan.ZNIECHECONY;
        } else if (przestraszonyNum > 5 && !stan.equals(Stan.POIRYTOWANY)) {
            stan = Stan.POIRYTOWANY;
        } else if (przestraszonyNum > 2 && !stan.equals(Stan.NEUTRALNY)) {
            stan = Stan.NEUTRALNY;
        }

        System.out.println(this);
    }

    @Override
    public boolean isKupiec() {
        return true;
    }

    public Stan getStan() {
        return stan;
    }
    
    @Override
    public String toString() {
        return "Kupiec{" +
                "stan=" + stan +
                '}';
    }

    public enum Stan {
        CHETNY, NEUTRALNY, POIRYTOWANY, ZNIECHECONY
    }
}
