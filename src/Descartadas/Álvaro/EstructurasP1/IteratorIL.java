package Descartadas.Álvaro.EstructurasP1;

import Descartadas.Álvaro.Nodos.Listas.ElementD;

public class IteratorIL<T> implements MyIterator<T>{
    private ElementD<T> current;
    private int steps;
    private int size;

    public <T> IteratorIL(ElementD<T> head, int size) {
    }

    @Override
    public boolean hasNext(){
        return current!=null && steps<size;
    }

    @Override
    public T next(){
        T data=null;
        if(hasNext()==true){
            data= current.getData();
            current=current.getNext();
            steps++;
        }
        return data;
    }
}

