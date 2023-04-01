package Statki;

public class Main {
    public static void main(String[] args) {
        Gra gra = new Gra();
        gra.pokazPlansze();
        gra.graj(30);
        gra.pokazPlansze();
    }
}