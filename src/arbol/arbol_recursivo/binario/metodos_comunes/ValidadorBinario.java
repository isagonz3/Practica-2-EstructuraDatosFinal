package arbol.arbol_recursivo.binario.metodos_comunes;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public class ValidadorBinario {

    public static <T extends Comparable<T>> boolean esCompleto(NodoBinario<T> root) {
        // Árbol completo: todas las hojas al mismo nivel
        int altura = altura(root);
        return esCompletoRec(root, 0, altura);
    }

    private static <T extends Comparable<T>> boolean esCompletoRec(NodoBinario<T> nodo, int nivel, int altura) {
        if (nodo == null) return true;
        if (nodo.getLeft() == null && nodo.getRight() == null) {
            return nivel == altura;
        }
        if (nodo.getLeft() == null || nodo.getRight() == null) return false;
        return esCompletoRec(nodo.getLeft(), nivel + 1, altura)
                && esCompletoRec(nodo.getRight(), nivel + 1, altura);
    }

    public static <T extends Comparable<T>> boolean esCasiCompleto(NodoBinario<T> root) {
        if (root == null) return true;

        estructuras_necesarias.ListSE<NodoBinario<T>> cola = new estructuras_necesarias.ListSE<>();
        cola.addLast(root);
        boolean encontradoHueco = false;

        while (!cola.isEmpty()) {
            NodoBinario<T> actual = cola.get(0);
            cola.del(actual);

            if (actual.getLeft() != null) {
                if (encontradoHueco) return false;
                cola.addLast(actual.getLeft());
            } else {
                encontradoHueco = true;
            }

            if (actual.getRight() != null) {
                if (encontradoHueco) return false;
                cola.addLast(actual.getRight());
            } else {
                encontradoHueco = true;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean esHomogeneo(NodoBinario<T> root) {
        int grado = grado(root);
        return esHomogeneoRec(root, grado);
    }

    private static <T extends Comparable<T>> boolean esHomogeneoRec(NodoBinario<T> nodo, int grado) {
        if (nodo == null) return true;
        int hijos = 0;
        if (nodo.getLeft() != null) hijos++;
        if (nodo.getRight() != null) hijos++;
        if (hijos != 0 && hijos != grado) return false;
        return esHomogeneoRec(nodo.getLeft(), grado) && esHomogeneoRec(nodo.getRight(), grado);
    }

    private static <T extends Comparable<T>> int altura(NodoBinario<T> nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.getLeft()), altura(nodo.getRight()));
    }

    private static <T extends Comparable<T>> int grado(NodoBinario<T> nodo) {
        if (nodo == null) return 0;
        int hijos = 0;
        if (nodo.getLeft() != null) hijos++;
        if (nodo.getRight() != null) hijos++;
        return Math.max(hijos, Math.max(grado(nodo.getLeft()), grado(nodo.getRight())));
    }
}