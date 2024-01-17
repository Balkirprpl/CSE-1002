/*
 * Author: Joao Gabriel Andrade Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Manatee Vocalization
*/

import java.util.Scanner;

public class Vocalization {
   public static void main (final String[] args) {

      // creating the scanner object
      final Scanner in = new Scanner (System.in);

      // reading all the inputs and outputing the results
      while (in.hasNextLine()) {
         final long search = in.nextLong();
         int iteration = 0;

         // calling the method to find how many iterations it takes
         // to fit the index being searched
         while (search > findLength(iteration, 0)) {
            iteration++;
         }
         System.out.println(findIndex(search, iteration) + " ");         
      }
   }

   // this method returns the length of a defined amount of iterations
   // by using the formula for the problem
   // base case V(0) = 3
   // V(n) = 2*V(n-1) + (V(0) + n)
   static long findLength (final int iteration, final long totalLength) {
      long calculate = totalLength;
      if (iteration == 0) {
         calculate += 3;
      } else {
         final long temp = findLength(iteration - 1, calculate);
         calculate += temp*2 + iteration + 3;
      }
      return calculate;
   }

   static char findIndex (final long search, final int iteration) {
      
      // finding the total length of a certain n
      // then finding the length of the middle part
      // and the first and last indexes
      final long totalIndex = findLength(iteration, 0);
      final long middlelength = 3 + iteration;
      final long startingIndex = (totalIndex/2) - (middlelength/2) + 1;
      final long endingIndex;
      if (iteration % 2 == 0) {
         endingIndex = (totalIndex/2) + (middlelength/2) + 1;
      }
      else {
         endingIndex = (totalIndex/2) + (middlelength/2);
      }
      char ans = ' ';

      // if the index searched is
      // the first character of the middle part it is k
      // if not but in the middle, it is i
      // if it is less than the first index, it searches v(n-1)
      // if it is more than the last index, it searches v(n-1)
      // but subtracts te nunber searched by the ending index
      // to make sure it still fits V(n-1)
      if (search == startingIndex) {
         ans = 'k';
      }
      else if (search > startingIndex && search <= endingIndex) {
         ans = 'i';
      }
      else if (search < startingIndex) {
         ans = findIndex(search, iteration - 1);
      }
      else if (search > endingIndex) {
         ans = findIndex(search - endingIndex, iteration - 1);
      } 
      return ans;
   }
}
