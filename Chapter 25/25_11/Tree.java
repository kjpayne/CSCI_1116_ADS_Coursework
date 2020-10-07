/*
 * Author: Kaden Payne
 * Date: 10/07/2020
 * 
 * Tree Interface
 */
import java.util.Collection;
/**
 *
 * @author kjpay
 */
public interface Tree<E> extends Collection<E> {
    //Searches tree for element
    public boolean search(E e);
    
    //Adds element to tree
    public boolean insert(E e);
    
    //Removes element from tree
    public boolean delete(E e);
    
    //Returns size of tree
    public int getSize();
    
    //Travers inorder
    public default void inorder() {
        
    }
    
    //Travers postorder
    public default void postorder() {
        
    }
    
    //Travers preorder
    public default void preorder() {
        
    }
    
    //Checks if tree is empty
    @Override
    public default boolean isEmpty() {
        return this.size() == 0;
    }
    
    //Checks if tree contains element
    @Override
    public default boolean contains(Object e) {
        return search((E) e);
    }
    
    //Add, remove, and return size
    @Override
    public default boolean add(E e) {
        return insert(e);
    }
    @Override
    public default boolean remove(Object e) {
        return delete((E) e);
    }
    @Override
    public default int size() {
        return getSize();
    }
    
    //Contains, add, remove, and retain all
    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public default boolean addAll(Collection<? extends E> c) {
        return false;
    }
    @Override
    public default boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public default boolean retainAll(Collection<?> c) {
        return false;
    }
    
    //Casting tree into an array
    @Override
    public default Object[] toArray() {
        return null;
    }
    @Override
    public default <T> T[] toArray(T[] array) {
        return null;
    }
}
