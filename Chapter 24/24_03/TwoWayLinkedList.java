/*
 * Author: Kaden Payne
 * Date: 9/15/2020
 * 
 * Creating two way linked list
 */
import java.util.ListIterator;
import javax.lang.model.element.*;
/**
 *
 * @author kjpay
 */
public class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E> {
    private Node<E> head, tail;
    private int size;
    
    //Constructors
    public TwoWayLinkedList() {
        
    }
    public TwoWayLinkedList(E[] objects) {
        for (E e : objects) {
            add(e);
        }
    }
    
    //Return head element of list
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }
    
    //Return tail element of list
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }
    
    //Adding to head of list
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;
        
        if (tail == null) {
            tail = head;
        }
        
        if (head != tail) {
            (head.next).previous = head;
        }
    }
    
    //Adding to tail of list
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e);
        
        Node<E> temp = tail;
        
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
            tail.previous = temp;
        }
        
        size++;
    }
    
    //Adding to a specified index
    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        }
        else if (index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            temp.previous = current.next;
            (current.next).previous = current;
            size++;
        }
    }
    
    //Removing the head of list
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = head;
            }
            return temp.element;
        }
    }
    
    //Removing tail of tail
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> current = head;
            
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }
    
    //Removing at a specified index
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;
            
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            
            Node<E> current = previous.next;
            previous.next = current.next;
            current.next.previous = previous;
            size--;
            return current.element;
        }
    }
    
    //toString Method
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
            else {
                result.append("]");
            }
        }
        
        return result.toString();
    }
    
    //Clearing the list
    @Override
    public void clear() {
        head = tail = null;
    }
    
    //Checking list for an element
    @Override
    public boolean contains(Object e) {
        Node<E> current = head;
        
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return true;
            }
            else {
                current = current.next;
            }
        }
        return false;
    }
    
    //Getting element at a specicfied index
    @Override
    public E get(int index) {
        Node<E> current = head;
        
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return head.element;
        }
        else if (index == size - 1) {
            return tail.element;
        }
        else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        
        return current.element;
    }
    
    //Returning index of an element
    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        int index = -1;
        
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                index = i;
            }
            else {
                current = current.next;
            }
        }
        return index;
    }
    @Override
    public int lastIndexOf(Object e) {
        Node<E> current = tail;
        int index = -1;
        
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(e)) {
                index = i;
            }
            else {
                current = current.previous;
            }
        }
        return index;
    }
    
    //Replacing element at a specified index with a specified element
    @Override
    public E set(int index, E e) {
        Node<E> current = head;
        
        for (int i = 0; i < size; i++) {
            current = current.next;
        }
        
        Node<E> temp = current;
        current = new Node<E>(e);
        return temp.element;
    }
    
    //Overriding iterator method
    @Override
    public java.util.ListIterator<E> iterator() {
        return new LinkedListIterator<E>();
    }
    
    private class LinkedListIterator<E> implements java.util.ListIterator<E> {
        private Node<E> current = (Node<E>)head;
        int index = 0;
        
        //Constructors
        public LinkedListIterator() {
            
        }
        public LinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size);
            }
            
            for (int nextIndex = 0; nextIndex < index; nextIndex++) {
                current = current.next;
            }
        }
        
        @Override
        public boolean hasNext() {
            return (current != null);
        }
        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
        @Override
        public void remove() {
            TwoWayLinkedList.this.remove(current);
        }
        @Override
        public void add(E e) {
            Node<E> temp = current.previous;
            current.next = current;
            current = new Node<E>(e);
            (current.next).previous = current;
            current.previous = temp;
        }
        @Override
        public boolean hasPrevious() {
            return current != head;
        }
        @Override
        public int nextIndex() {
            int nextIndex = TwoWayLinkedList.this.indexOf(current.next);
            return nextIndex;
        }
        @Override
        public E previous() {
            E e = current.element;
            current = current.previous;
            return e;
        }
        @Override
        public int previousIndex() {
            int previousIndex = TwoWayLinkedList.this.indexOf(current.previous);
            return previousIndex;
        }
        @Override
        public void set(E e) {
            current.element = e;
        }
    }
    
    public class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;
        
        public Node(E o) {
            element = o;
        }
    }
    
    //Returns size of list
    @Override
    public int size() {
        return size;
    }
    
    //Returns LinkedListIterator with a specified index
    @Override
    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator<E>(index);
    }
}
