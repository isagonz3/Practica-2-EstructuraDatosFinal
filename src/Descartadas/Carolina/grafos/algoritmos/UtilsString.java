package Descartadas.Carolina.grafos.algoritmos;

public class UtilsString {

    public static boolean iguales(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}