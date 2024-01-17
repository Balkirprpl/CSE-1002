/*
 * Author: Joao Silva, jsilva2021@gmy.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Page Rank
 */

import java.util.Scanner;

public class RandomSurfer {
   public static void main (final String[] args) {
      final Scanner in = new Scanner (System.in);
      final int trials = Integer.parseInt(args[0]);   // number of moves
      final int m = in.nextInt();                  // number of pages  - ignore since m = n
      final int n = in.nextInt();                  // number of pages
      if (m != n) {
         System.out.println("m does not equal n");
         return;
      }

      // Read transition matrix.
      // p[i][j] = prob. that surfer moves from page i to page j
      final double[][] p = new double[n][n];
      for (int i = 0; i < n; i++)
         for (int j = 0; j < n; j++) 
            p[i][j] = in.nextDouble(); 


      final int[] freq = new int[n]; // freq[i] = # times surfer hits page i
 
      // Start at page 0. 
      int page = 0;

      for (int t = 0; t < trials; t++) {

         // Make one random move. 
         final double r = Math.random(); 
         double sum = 0.0; 
         for (int j = 0; j < n; j++) {
            // Find interval containing r. 
            sum += p[page][j]; 
            if (r < sum) {
               page = j;
               break;
            } 
         } 
         freq[page]++; 
      } 


      // Print page ranks. 
      for (int i = 0; i < n; i++) {
         final double division = freq[i]/trials;
         System.out.printf("%8.5f", division); 
      }
      System.out.println(); 
   }  
} 
