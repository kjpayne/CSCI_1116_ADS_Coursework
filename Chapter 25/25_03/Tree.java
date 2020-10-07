/*
 * Author: Kaden Payne
 * Date: 10/05/2020
 * 
 * Binary Tree interface
 */
import java.util.Collection;
/**
 *
 * @author kjpay
 */
public interface Tree<E> extends Collection<E> {
    //Searching if an element is in the tree
    public boolean search(E e);
    
    //Adding an element into the tree
    public boolean insert(E e);
    
    //Removing an element from the tree
    public boolean delete(E e);
    
    //Returning size of tree
    public int getSize();
    
    //Inorder Traversal
    public default void inorder() {
        
    }
    
    //Postorder Traversal
    public default void postorder() {
        
    }
    
    //Preorder Traversal
    public default void preorder() {
        
    }
    
    //Checking if tree is empty
    @Override
    public default boolean isEmpty() {
        return this.size() == 0;
    }
    
    //Checking if tree contains element
    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }
    
    //Adding to tree
    @Override
    public default boolean add(E e) {
        return insert(e);
    }
    
    //Removing from tree
    @Override
    public default boolean remove(Object e) {
        return delete((E)e);
    }
    
    //Returning size of tree
    @Override
    public default int size() {
        return getSize();
    }
    
    //Containing all elements in one tree that an tree has
    @Override
    public default boolean containsAll(Collection<?> c) {
        //left as an exercise
        return false;
    }
    
    //Adding all elements from one tree to other
    @Override
    public default boolean addAll(Collection<? extends  E> c) {
        //left as an exercise
        return false;
    }
    
    //Removing all elements that one tree has from other tree
    @Override
    public default boolean removeAll(Collection <?> c) {
        //left as an exercise
        return false;
    }
    
    //Retaining all elements from one tree in other tree
    @Override
    public default boolean retainAll(Collection<?> c) {
        //left as an exercise
        return false;
    }
    
    //Converting tree into an array
    @Override
    public default Object[] toArray() {
        //left as an exercise
        return null;
    }
    
    //
    @Override
    public default <T> T[] toArray(T[] array) {
        //left as an exercise
        return null;
    }
}