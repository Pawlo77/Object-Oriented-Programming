package pl.edu.pw.mini.zpoif.assignments.fourth;

import java.lang.reflect.Method;

public class Demonstrator {
    private static void demonstrate() {
        BazaOkretow r = new Rozwiazanie();

        Method[] methods = BazaOkretow.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("method")) {
                System.out.println("\n" + method.getName());
                try {
                    System.out.println(method.invoke(r));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demonstrator.demonstrate();
    }
}
