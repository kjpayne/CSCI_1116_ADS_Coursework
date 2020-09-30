/*
 * Author: Kaden Payne
 * Date: 9/28/2020
 * 
 * Sorting GeometricObjects with comparables and comparators
 */
import java.util.Comparator;
/**
 *
 * @author kjpay
 */
public class SortingGeometricObjects {
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++) {
          System.out.print(list[i] + " ");
        }
        System.out.println();
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                         new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                         new Circle(3), new Circle(14), new Circle(12)};
        quickSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++) {
          System.out.println(list1[i] + " ");
        }
    }
    
    //quickSort methods
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }
    
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            quickSort(list, 0, list.length - 1, comparator);
        }
    }
    
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    
    public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partition(list, first, last, comparator);
            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }
    
    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        //Commented System.out.printlns are for testing
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        /*
        System.out.println("first = " + first + ". last = " + last + ". pivot = " + pivot);
        for (int i = first; i <= last; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\nlow = " + list[low] + ". high = " + list[high]);*/

        //Looping to search the array to swap elements in the array
        while (high > low) {
            while (low <= high && list[low].compareTo(pivot) <= 0) {
                //System.out.println("list[low](" + list[low] + ").compareTo(pivot(" + pivot + ")) = " + list[low].compareTo(pivot));
                low++;
                //System.out.println("low = " + list[low]);
            }
            while (low <= high && list[high].compareTo(pivot) > 0) {
                //System.out.println("list[high](" + list[high] + ").compareTo(pivot(" + pivot + ")) = " + list[high].compareTo(pivot));
                high--;
                //System.out.println("high = " + list[high]);
            }
            if (high > low) {
                //System.out.println("Swapping high(" + list[high] + ") with low(" + list[low] + ").");
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                /*
                for (int i = first; i <= last; i++) {
                    System.out.print(list[i] + " ");
                }
                System.out.println();*/
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
            //System.out.println("high(" + list[high] + ") is moving down.");
        }
        
        //Swaps pivot with list[high] if pivot is great than list[high]
        if (pivot.compareTo(list[high]) > 0) {
            //System.out.println("list[first] before: " + list[first] + ". list[high] before: " + list[high]);
            list[first] = list[high];
            list[high] = pivot;
            /*System.out.println("list[first] after: " + list[first] + ". list[high] after: " + list[high]);
            
            System.out.println("Swapping pivot(" + pivot + ") with high(" + list[high] + ").");
            for (int i = first; i <= last; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();*/

            return high;
        }
        else {
            return first;
        }
    }
    
    public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
        //Commented System.out.printlns are for testing
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        /*System.out.println("first = " + first + ". last = " + last + ". pivot = " + pivot);
        for (int i = first; i <= last; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\nlow = " + list[low] + ". high = " + list[high]);*/
        
        while (high > low) {
            while (low <= high && comparator.compare(list[low], pivot) <= 0) {
                //System.out.println("comparator.compare(list[low](" + list[low] + "), pivot(" + pivot + ")) = " + comparator.compare(list[low], pivot));
                low++;
                //System.out.println("low = " + list[low]);
            }
            while (low <= high && comparator.compare(list[high], pivot) > 0) {
                //System.out.println("comparator.compare(list[high](" + list[high] + "), pivot(" + pivot + ")) = " + comparator.compare(list[low], pivot));
                high--;
                //System.out.println("high = " + list[high]);
            }
            if (high > low) {
                //System.out.println("Swapping high(" + list[high] + ") with low(" + list[low] + ").");
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                /*
                for (int i = first; i <= last; i++) {
                    System.out.print(list[i] + " ");
                }
                System.out.println();*/
            }
        }
        while (high > first && comparator.compare(list[high], pivot) >= 0) {
            high--;
            //System.out.println("high(" + list[high] + ") is moving down.");
        }
        
        //Swaps pivot with list[high] if pivot is great than list[high]
        if (comparator.compare(pivot, list[high]) > 0) {
            //System.out.println("list[first] before: " + list[first] + ". list[high] before: " + list[high]);
            list[first] = list[high];
            list[high] = pivot;
            /*System.out.println("list[first] after: " + list[first] + ". list[high] after: " + list[high]);
            
            System.out.println("Swapping pivot(" + pivot + ") with high(" + list[high] + ").");
            for (int i = first; i <= last; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();*/

            return high;
        }
        else {
            return first;
        }
    }
}