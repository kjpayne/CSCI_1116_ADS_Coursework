/*
 * Author: Kaden Payne
 * Date: 9/30/2020
 * 
 * Modifying Heap class to be a min-heap
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    
    //Constructors
    public Heap() {
        
    }
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }
    
    //Adding objects to heap
    public void add(E newObject) {
        //Commented System.out.printlns are for testing
        list.add(newObject);
        int currentIndex = list.size() - 1;
        //System.out.println("currentIndex = " + currentIndex + "(Adding)");
        
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) <= 0) {
                //System.out.println("list.get(currentIndex) before: " + list.get(currentIndex) + ". list.get(parentIndex) before: " + list.get(parentIndex));
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
                /*System.out.println("list.get(currentIndex) after: " + list.get(currentIndex) + ". list.get(parentIndex) after: " + list.get(parentIndex));
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();*/
            }
            else {
                break;
            }
            
            currentIndex = parentIndex;
        }
    }
    
    //Removing objects from heap
    public E remove() {
        //Commented System.out.printlns are for testing
        if (list.size() == 0) return null;
        
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if (leftChildIndex >= list.size()) break;
            int minIndex = leftChildIndex;
            //System.out.println("minIndex = " + leftChildIndex + "(Left)");
            if (rightChildIndex < list.size()) {
                if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0) {
                    minIndex = rightChildIndex;
                    //System.out.println("minIndex = " + rightChildIndex + "(Right)");
                }
            }
            //Swapping objects
            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                //System.out.println("list.get(currentIndex) before: " + list.get(currentIndex) + ". list.get(minIndex) before: " + list.get(minIndex));
                E temp = list.get(minIndex);
                list.set(minIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                //System.out.println("list.get(currentIndex) after: " + list.get(currentIndex) + ". list.get(minIndex) after: " + list.get(minIndex));
                currentIndex = minIndex;
                /*System.out.println("currentIndex = " + currentIndex);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();*/
            }
            else {
                break;
            }
        }
        
        return removedObject;
    }
    
    //Getting size of heap
    public int getSize() {
        return list.size();
    }
    
    //Checking if heap is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
