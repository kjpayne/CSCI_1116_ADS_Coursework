/*
 * Author: Kaden Payne
 * Date: 9/21/2020
 * 
 * Modifying Exercise 8.37 to input the state and return the capital
 */
import java.util.*;
/**
 *
 * @author kjpay
 */
public class StateCapital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
        //Making HashMap
        HashMap<String, String> map = new HashMap();
        
        //Adding values for stateCapital array to map
        for (int i = 0; i < stateCapital.length; i++) {
            map.put(stateCapital[i][0].toUpperCase(), stateCapital[i][1].toUpperCase());
        }
        //Displaying map for testing
        //map.forEach((k, v) -> System.out.println(k + "\t" + v));
        
        //Creating loop to keep entering
        boolean entering = true;
        while (entering) {
            //Entering state
            System.out.print("Enter state: ");
            String state = input.nextLine().trim().toUpperCase();
            //Displaying capital
            System.out.println("The capital is " + map.get(state));
        }
        
    }
}
