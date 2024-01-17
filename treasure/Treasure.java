/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Treasure Hunt
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Treasure {
   public static void main (final String[] args) {
      Scanner in = new Scanner(System.in, "US-ASCII");


      int[] input = {0, 0, 0};
      int sum1 = 0;
      int sum2 = 0;
      int sum3 = 0;
      int total = 0;
      while (in.hasNext()) {
         input[0] = in.nextInt();
         input[1] = in.nextInt();
         input[2] = in.nextInt();
         int a = in.nextInt();
         int b = in.nextInt();
         int c = in.nextInt();

         sum1 += a + Math.max(input[1], input[2]);
         sum2 += b + Math.max(input[0], input[2]);
         sum3 += c + Math.max(input[1], input[0]);

         input[0] = a;
         input[1] = b;
         input[2] = c;
         
         if (sum1 > sum2 && sum1 > sum3) total = sum1;
         if (sum2 > sum1 && sum2 > sum3) total = sum2;
         if (sum3 > sum1 && sum3 > sum2) total = sum3;
      }
      System.out.println(total);
   }
}