/*
 * Author: Joao Silva, jsilva2021@gmy.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Page Rank
 */

import java.util.Scanner;
 
public class Transition {
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);

      // number of pages
      final int n = in.nextInt();           

      // counts[i][j] = # links from page i to page j
      final int[][] counts = new int[n][n];    
      
      // outDegree[i] = # links from page i to anywhere
      final int[] outDegree = new int[n];      
      // Accumulate link counts. 
      
      int m; 
      int k;  
      while (in.hasNext())   {
         m = in.nextInt(); 
         k = in.nextInt(); 
         outDegree[m]++; 
         counts[m][k]++; 
      } 
      System.out.println(n + " " + n); 
      // Print probability distribution for row i. 

      final double percentH = 0.90;
      final double percentL = 0.10;

      for (int i = 0; i < n; i++)  {
         // Print probability for column j. 
         for (int j = 0; j < n; j++) {
            
            double p = percentH*counts[i][j]/outDegree[i] + percentL/n;
            if (counts[i][j] == 0) {
               p = 1/n;
            }
            System.out.printf(" %.2f ", p); 
         } 
         System.out.println(); 
      } 
   } 
} 
