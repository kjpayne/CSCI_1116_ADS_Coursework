/*
 * Author: Kaden Payne
 * Date: 9/14/2020
 * 
 * Interface for making list, methods to add and remove
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public interface MyList<E> extends java.lang.Iterable {
    //Adding to the list
    public void add(E e);
    
    public void add(int index, E e);
    
    //Clearing list
    public void clear();
    
    //Checking contents of the list
    public boolean contains(E e);
    
    public E get(int index);
    
    public int indexOf(E e);
    
    public boolean isEmpty();
    
    public int lastIndexOf(E e);
    
    public boolean remove(E e);
    
    public E remove(int index);
    
    public Object set(int index, E e);
    
    public int size();
    
    //New methods, addAll, removeAll, retainAll
    /** Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call
     * @param otherList another MyList
     * @return true if changed
     */
    public boolean addAll(MyList<E> otherList);
    
    /** Removes all the elements in otherList from this list.
     * Returns true if this list changed as a result of the call
     * @param otherList another MyList
     * @return true if changed
     */
    public boolean removeAll(MyList<E> otherList);
    
    /** Retains the elements in this list that are also in otherList
     * Returns true if this list changed as a result of the call
     * @param otherList another MyList
     * @return true if changed
     */
    public boolean retainAll(MyList<E> otherList);
}
