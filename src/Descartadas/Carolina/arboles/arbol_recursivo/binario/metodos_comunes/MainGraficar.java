package Descartadas.Carolina.arboles.arbol_recursivo.binario.metodos_comunes;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public class MainGraficar {

    public static void main(String[] args) {

        NodoBinario<Integer> raiz = new NodoBinario<>(8);

        raiz.setLeft(new NodoBinario<>(3));
        raiz.setRight(new NodoBinario<>(10));

        raiz.getLeft().setLeft(new NodoBinario<>(1));
        raiz.getLeft().setRight(new NodoBinario<>(6));

        raiz.getLeft().getRight().setLeft(new NodoBinario<>(4));
        raiz.getLeft().getRight().setRight(new NodoBinario<>(7));

        raiz.getRight().setRight(new NodoBinario<>(14));
        raiz.getRight().getRight().setLeft(new NodoBinario<>(13));

        System.out.println(GraficadorBinario.toGraficarString(raiz));
    }
}