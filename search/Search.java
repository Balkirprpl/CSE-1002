/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Search a List
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.text.Collator;
import java.util.Locale;

public class Search {
   public static void main (final String[] args) {

      // creating the primary array 
      // and the array that will be sorted before outputing.
      final ArrayList<String> arr = new ArrayList<String>();
      final ArrayList<String> ansarr = new ArrayList<String>();
      final Collator sorting = Collator.getInstance(Locale.US);
      final Scanner in = new Scanner(System.in);
      while (in.hasNextLine()) {
         final String input = in.next();

         // Checking if the input starts with a question mark,
         // if not, add the manatee to the list.
         if (input.equals("?")) {

            // getting the second and third input
            // and getting the int values of their indexes.
            final String indexManatee1 = in.next();
            final String indexManatee2 = in.next();
            final int index1 = arr.indexOf(indexManatee1);
            final int index2 = arr.indexOf(indexManatee2);
            
            // checking if manatees are inside the array
            if (index2 == -1 || index1 == -1) {
               System.out.println("Absent");
            }
            // checking if the order follows the same as the the List
            else if (index1 > index2) {
               System.out.println("Nonesuch");
            }
            else if (index1 >= 0 && index2 >= 0) {
               for (int i = index1; i < index2 + 1; i++) {
                  ansarr.add(arr.get(i)); // adding all the names in between to the new list
                  ansarr.sort(sorting); // sorting the list
               }
               for (int i = 0; i < ansarr.size(); i++) {
                  System.out.printf(" %d: %s%n", i + 1, ansarr.get(i)); // outputting the list
               }
               ansarr.clear(); // clearing the ans list everytime
            }
         }
         else {
            arr.add(input); // adding the manatee's name to the primary array.
         }
      }
   }
}
