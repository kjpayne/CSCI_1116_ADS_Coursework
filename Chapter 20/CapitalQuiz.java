/*
 * Author: Kaden Payne
 * Date: 9/8/2020
 * 
 * Modifying Exercise8.37 to randomize the array for display
 */
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author kjpay
 */
public class CapitalQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Creating String array with States and Capitals
        String[][] stateCapital = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusettes", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "Saint Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
        };
        
        //Converting the array into two stacks
        Stack<String> stateStack = new Stack<>();
        for (int i = 0; i < stateCapital.length; i++) {
            stateStack.push(stateCapital[i][0]);
        }
        Stack<String> capitalStack = new Stack<>();
        for (int i = 0; i < stateCapital.length; i++) {
            capitalStack.push(stateCapital[i][1]);
        }
        
        //Randomizing the Stacks while randomizing the randomizing
        int rng = getRandomNumber(1, 50);
        Collections.shuffle(stateStack, new Random(rng));
        Collections.shuffle(capitalStack, new Random(rng));
        //System.out.println(stateStack);
        //System.out.println(capitalStack);
        
        //Quiz Time
        int correctCount = 0;
        
        //Display question
        for (int i = 0; i < 50; i++) {
            System.out.print("What is the capital of " + stateStack.pop() + "?: ");
            String capital = input.nextLine().trim().toLowerCase();
            
            if (capital.toLowerCase().equals(capitalStack.peek().toLowerCase())) {
                System.out.println("Yes! " + capitalStack.pop() + " is correct!");
                correctCount++;
            }
            else {
                System.out.println("No, the correct answer is " + capitalStack.pop());
            }
            //System.out.println(stateStack);
            //System.out.println(capitalStack);
        }
        
        //Display the amount of correct answers
        System.out.println("You got " + correctCount + " out of 50 correct.");
    }
    
    //RNG
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    } 
}
