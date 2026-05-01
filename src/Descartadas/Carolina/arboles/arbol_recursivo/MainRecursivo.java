package Descartadas.Carolina.arboles.arbol_recursivo;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda.ArbolBinarioDeBusquedaEnteros;
import Descartadas.Carolina.estructuras_necesarias.MyIterate;
import Descartadas.Carolina.estructuras_necesarias.MyList;

import java.util.Random;

public class MainRecursivo {

    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros arbolInsercionOrdenada = new ArbolBinarioDeBusquedaEnteros();

        for (int i = 0; i <= 128; i++) {
            arbolInsercionOrdenada.insertar(i);
        }

        System.out.println("Caso 1: inserción ordenada");
        probarArbol(arbolInsercionOrdenada);

        ArbolBinarioDeBusquedaEnteros arbolInsercionAleatoria = new ArbolBinarioDeBusquedaEnteros();

        int[] numeros = new int[129];
        for (int i = 0; i <= 128; i++) numeros[i] = i;

        mezclarArray(numeros);

        for (int n : numeros) {
            arbolInsercionAleatoria.insertar(n);
        }

        System.out.println("\nCaso 2: inserción aleatoria");
        probarArbol(arbolInsercionAleatoria);
    }

    private static void probarArbol(ArbolBinarioDeBusquedaEnteros arbol) {

        int sumaTotal = arbol.calcularSumaElementos();
        System.out.println("Suma total: " + sumaTotal);

        MyList<Integer> preorden = arbol.getListaPreOrden();
        MyList<Integer> inorden = arbol.getListaOrdenCentral();
        MyList<Integer> postorden = arbol.getListaPostOrden();

        System.out.println("Suma preorden: " + sumarLista(preorden));
        System.out.println("Suma inorden: " + sumarLista(inorden));
        System.out.println("Suma postorden: " + sumarLista(postorden));

        System.out.println("Altura: " + arbol.getAltura());

        MyList<Integer> camino110 = arbol.getCamino(110);

        System.out.print("Camino hasta 110: ");
        imprimirLista(camino110);

        System.out.println("Longitud del camino: " + (camino110.getSize() - 1));
    }

    private static int sumarLista(MyList<Integer> lista) {

        MyIterate<Integer> iterador = lista.getIterate();
        int suma = 0;

        while (iterador.hasNext()) {
            suma += iterador.next();
        }

        return suma;
    }

    private static void imprimirLista(MyList<Integer> lista) {

        MyIterate<Integer> iterador = lista.getIterate();
        boolean primero = true;

        while (iterador.hasNext()) {

            if (!primero) System.out.print(" -> ");

            System.out.print(iterador.next());
            primero = false;
        }

        System.out.println();
    }

    private static void mezclarArray(int[] arr) {

        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}