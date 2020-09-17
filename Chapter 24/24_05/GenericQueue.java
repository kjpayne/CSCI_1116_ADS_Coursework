/*
 * Author: Kaden Payne
 * Date: 9/16/2020
 * 
 * Inheriting LinkedList to GenericQueue
 */
import java.util.LinkedList;
/**
 *
 * @author kjpay
 */
public class GenericQueue<E> extends LinkedList<E> {
    private LinkedList<E> list = new LinkedList();
    
    //Constructors
    public GenericQueue(){
        
    }
    public GenericQueue(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            list.add(objects[i]);
        }
    }
    
    //Adding and removing from queue
    public void enqueue(E e) {
        list.addLast(e);
    }
    public E dequeue() {
        return list.removeFirst();
    }
    
    //Return size of Queue
    public int getSize() {
        return list.size();
    }
    
    //toString method
    @Override
    public String toString() {
        return "Queue " + list.toString();
    }
}
