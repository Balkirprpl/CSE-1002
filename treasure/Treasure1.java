/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Treasure Hunt
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Treasure1 {
   record Rows(int a, int b, int c) {}
      
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in, "US-ASCII");
      final ArrayList<Rows> inputs = new ArrayList<>();


      // creating the record
      while (in.hasNextLine()) {
         inputs.add(new Rows(in.nextInt(), in.nextInt(), in.nextInt()));
      }

      int maxIndex = 0;
      if ((inputs.get(0).a < inputs.get(0).b)) maxIndex = 1;
      else maxIndex = 0;
      if ((inputs.get(0).b < inputs.get(0).c)) maxIndex = 2;

      System.out.println(calculateValue(inputs, 0, 0, maxIndex));
   }

   public static int calculateValue (final ArrayList<Rows> arr,
         final int sum, final int line, final int startingIndex) {
      
      int total = 0;
      // base case of the method
      if (line == arr.size()) {
         return 0;
      }

      // finding which number is being checked and adding the total to the max of
      // the other two indexes.
      else if (startingIndex == 0) {
         if (calculateValue(arr, total, line + 1, 1) <= calculateValue(arr,
               total, line + 1, 2)) {
            total = calculateValue(arr, total, line + 1, 2);
         }
         else {
            total = calculateValue(arr, total, line + 1, 1);
         }
         return total + Math.max(arr.get(line).b, arr.get(line).c);
      }


      // finding which number is being checked and adding the total to the max of
      // the other two indexes.
      else if (startingIndex == 1) {
         if (calculateValue(arr, total, line + 1, 0) <= calculateValue(arr,
               total, line + 1, 2)) {
            total = calculateValue(arr, total, line + 1, 2);
         }
         else {
            total = calculateValue(arr, total, line + 1, 0);
         }
         return total + Math.max(arr.get(line).a, arr.get(line).c);
      }


      // finding which number is being checked and adding the total to the max of
      // the other two indexes.
      else if (startingIndex == 2) {
         if (calculateValue(arr, total, line + 1, 0) <= calculateValue(arr,
               total, line + 1, 1)) {
            total = calculateValue(arr, total, line + 1, 1);
         }
         else {
            total = (calculateValue(arr, total, line + 1, 0));
         }
         return total + Math.max(arr.get(line).a, arr.get(line).b);
      }
      return 0;
   }
}
