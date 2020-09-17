/*
 * Author: Kaden Payne
 * Date: 9/15/2020
 * 
 * Testing the new addAll, removeAll, and retainAll
 */
import java.util.*;
/**
 *
 * @author kjpay
 */
public class TestMyList {
    public static void main(String[] args) {
        new TestMyList();
    }
    
    public TestMyList() {
        String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
        
        //Testing addAll
        MyList<String> list1 = new MyArrayList<String>(name1);
        MyList<String> list2 = new MyArrayList<String>(name2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        list1.addAll(list2);
        System.out.println("After addAll: " + list1 + "\n");
        
        //Testing removeAll
        list1 = new MyArrayList<String>(name1);
        list2 = new MyArrayList<String>(name2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        list1.removeAll(list2);
        System.out.println("After removeAll: " + list1 + "\n");
        
        //Testing retainAll
        list1 = new MyArrayList<String>(name1);
        list2 = new MyArrayList<String>(name2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        list1.retainAll(list2);
        System.out.println("After retainAll: " + list1 + "\n");
    }
}
