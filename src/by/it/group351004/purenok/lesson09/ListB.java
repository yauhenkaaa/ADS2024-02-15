package by.it.group351004.purenok.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListB<E> implements List<E> {

    private final int INIT_SIZE = 10;
    private Object[] arr = new Object[INIT_SIZE];
    private int size = 0;
    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString(){
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            sb.append(arr[i]);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(E e) {
        if (size >= arr.length-1){
            Object[] temp = new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }
        arr[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (arr[index] == null)
            return null;
        E res = (E)arr[index];
        if (index < size - 1)
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        arr[size-1] = null;
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        Object[] temp = new Object[size + 1];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
        for (int i = size; i > index; i--)
            arr[i] = arr[i - 1];
        arr[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i]))
                index = i;
        }
        if (index == -1)
            return false;

        for (int i = index; i < size-1; i++)
            arr[i] = arr[i + 1];
        arr[size-1] = null;
        size--;
        return true;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size){
            Object[] temp = new Object[index+1];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
            arr[index] = element;
            return null;
        }
        E res = (E)arr[index];
        arr[index] = element;
        return res;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void clear() {
        arr = new Object[INIT_SIZE];
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        return (E)arr[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (o.equals(arr[i]))
                return true;
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size-1; i >= 0; i--){
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }


    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
