/*
 * Author: Kaden Payne
 * Date: 9/25/2020
 * 
 * Check if a substring is part of a string
 */
import java.util.*;
/**
 *
 * @author kjpay
 */
public class PatternMatching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Entering main string and substring
        System.out.print("Enter main String: ");
        String mainString = input.nextLine();
        System.out.print("Enter substring: ");
        String subString = input.nextLine();
        
        //Checking if substring is in the main string
        int index = patternFinding(mainString, subString);
        if (index == -1) {
            System.out.println(subString + " is not a substring of " + mainString + ".");
        }
        else {
            System.out.println(subString + " is a substring of " + mainString + ", starting at index " + index + ".");
        }
    }
    
    public static int patternFinding(String main, String sub) {
        int mainStartIndex = 0;
        int mainEndIndex = 1;
        int subStartIndex = 0;
        int subEndIndex = 1;
        String temp;
        boolean isFound = false;
        //Loop to find if substring is in the main string
        //The System.out.prints are for testing
        while (isFound == false) {
            if (main.substring(mainStartIndex, mainEndIndex).equals(sub.substring(subStartIndex, subEndIndex))) {
                temp = main.substring(mainStartIndex, mainEndIndex);
                //System.out.println(temp);
                if (temp.equals(sub)) {
                    isFound = true;
                }
                mainEndIndex++;
                subEndIndex++;
                //System.out.println(mainEndIndex + ", " + subEndIndex);
            }
            else {
                mainStartIndex++;
                mainEndIndex = mainStartIndex + 1;
                subEndIndex = 1;
                //System.out.println(mainStartIndex + ", " + mainEndIndex);
            }
            if (mainStartIndex == main.length() - 1) {
                mainStartIndex = -1;
                isFound = true;
            }
        }
        return mainStartIndex;
    }
}
