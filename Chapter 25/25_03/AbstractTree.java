/*
 * Author: Kaden Payne
 * Date: 10/05/2020
 * 
 * Abstract class of Tree
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {
    //Inorder Traversal
    @Override
    public void inorder() {
        
    }
    //Postorder Traversal
    @Override
    public void postorder() {
        
    }
    //Preorder Traversal
    @Override
    public void preorder() {
        
    }
    
    //Checking if tree is empty
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
