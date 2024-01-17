/*
* Author:  J Gabriel Andrade Silva, jsilva2021@my.fit.edu
* Course:  CSE 1002, Section 7, Fall 2021
* Project: Discount
*/

import java.util.Scanner;
import java.util.Arrays;

public final class Shop {
   public static void main (final String[] args) {
      final Scanner kb = new Scanner(System.in);
      final int amount = kb.nextInt();
      final int[] prices = new int[amount];
      int pos = 0;
      int discount = 0;
      final int limit = 200000;

      // Calculating how many times the professor will have to go to te checkout counter
      final int loops = (amount - (amount % 3))/3;

      for (int i = 0; i < amount; i++) {
         // Filling the array 'prices' with numbers from the input.
         prices[i] = kb.nextInt();

         // Checking if the limits are being respected
         if (amount >= limit || prices[i] >= limit) {
            throw new RuntimeException();
         }
      }
      
      // Using the Array library to sort the array 'prices'
      Arrays.sort(prices);

      // Getting numbers in the array jumping 3 positions each loop
      for (int i = 0; i < loops; i++) {
         discount = discount + prices[pos];
         pos = pos + 3;
      }
      System.out.println(discount);
   }
}
