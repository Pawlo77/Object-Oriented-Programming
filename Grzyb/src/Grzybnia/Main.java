package Grzybnia;

public class Main {
    public static void main(String[] args) {
        DajGrzyba dajGrzyba = new Las(0, 40);
        KonsumentGrzybow konsumentGrzybow = new KonsumentGrzybow(dajGrzyba);
        konsumentGrzybow.konsumujGrzyby(60);
    }
}