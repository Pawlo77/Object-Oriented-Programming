package BozenaPackage;

public class Main {
    public static void main(String[] args) {
        Pole pole = new Pole();
        Bozena bozena = new Bozena(pole);

//        System.out.println(pole);
        for (int i = 0; i < 50; i++)
            bozena.destroyMines();
//        System.out.println(pole);
    }
}