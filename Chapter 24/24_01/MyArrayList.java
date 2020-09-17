/*
 * Author: Kaden Payne
 * Date: 9/14/2020
 * 
 * An array class that extends MyAbstractList
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[])new Object[INITIAL_CAPACITY];
    private int size = 0;
    
    //Constructors
    public MyArrayList() {
        
    }
    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }
    
    //Adding to array list
    @Override
    public void add(int index, E e) {
        ensureCapacity();
        
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        
        size++;
    }
    
    //Checking capacity
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    
    //Clearing array
    @Override
    public void clear() {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    //Checking what it contains
    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return true;
        }
        return false;
    }
    
    //Get object at index and get index of object
    @Override
    public E get(int index) {
        return data[index];
    }
    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }
    
    //Removing object
    @Override
    public E remove(int index) {
        E e = data[index];
        
        for (int j = 0; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        
        data[size - 1] = null;
        
        size--;
        
        return e;
    }
    
    //Setting an object at index
    @Override
    public E set(int index, E e) {
        E old = data[index];
        data[index] = e;
        return old;
    }
    
    //toString Method
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        
        return result.toString() + "]";
    }
    
    //Trimming array to size
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    
    //Iterable method
    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }
    
    //Size of array
    @Override
    public int size() {
        return size;
    }
    
    public class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0;
        
        @Override
        public boolean hasNext() {
            return (current < size);
        }
        @Override
        public E next() {
            return data[current++];
        }
        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
