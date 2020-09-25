/*
 * Author: Kaden Payne
 * Date: 9/24/2020
 * 
 * Maximum consecutive increasingly ordered substring 
 */
import java.util.*;
/**
 *
 * @author kjpay
 */
public class MaxConsecutiveSubstring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Entering string to be substringed
        System.out.print("Enter a String: ");
        String word = input.next().toLowerCase();
        
        //Displaying substring of String
        System.out.println("The maximum consecutive substring for " + word + " is " + maxConsectiveSubstring(word));
    }
    
    public static String maxConsectiveSubstring(String word) {
        //Creating LinkedHashSet to remove duplicate letters
        LinkedHashSet<String> sub = new LinkedHashSet<>();
        for (int i = 0; i < word.length(); i++) {
            sub.add(word.charAt(i) + "");
        }
        //Creating an String array to organize the letter in order
        String[] array = sub.toArray(new String[sub.size()]);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    //System.out.println("> " + i + " " + array[i] + " " + j + " " + array[j]);
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    /*System.out.println(i + " " + array[i] + " " + j + " " + array[j]);
                    for (int f = 0; f < array.length; f++) {
                        System.out.print(array[f]);
                    }
                    System.out.println();*/
                }
            }
        }
        //Creating a new String with the reorganized letters to return
        String subWord = array[0];
        for (int i = 1; i < array.length; i++) {
            subWord += array[i];
        }
        
        return subWord;
    }
}
