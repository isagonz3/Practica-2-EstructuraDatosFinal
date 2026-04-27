package arbol.arbol_recursivo.binario.nodo;

public class NodoBinario<T extends Comparable<T>> implements Comparable<NodoBinario<T>> {

    private T data;
    private NodoBinario<T> left;
    private NodoBinario<T> right;

    public NodoBinario(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public NodoBinario<T> getLeft() { return left; }
    public void setLeft(NodoBinario<T> left) { this.left = left; }

    public NodoBinario<T> getRight() { return right; }
    public void setRight(NodoBinario<T> right) { this.right = right; }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(NodoBinario<T> o) {
        return 0;
    }
}
