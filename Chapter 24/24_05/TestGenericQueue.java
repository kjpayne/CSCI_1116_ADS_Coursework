/*
 * Author: Kaden Payne
 * Date: 9/16/2020
 * 
 * Testing the new GenericQueue
 */

/**
 *
 * @author kjpay
 */
public class TestGenericQueue {
    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue();
        queue.enqueue("Mario");
        System.out.println("1) " + queue);
        queue.enqueue("Luigi");
        System.out.println("2) " + queue);
        queue.enqueue("Link");
        queue.enqueue("Samus");
        System.out.println("3) " + queue);
        queue.dequeue();
        System.out.println("4) " + queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println("5) " + queue);
    }
}
