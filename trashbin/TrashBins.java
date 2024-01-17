/*
 * Author:  J Gabriel Andrade Silva, jsilva2021@my.fit.edu
 * Course:  CSE 1002, Section 07, Fall 2021
 * Project: Google Kickstart round f, Trash Bins
 */

import java.util.Scanner;

public class TrashBins {
   public static void main (final String[] args) {
      // Initializing the scanner
      final Scanner in = new Scanner(System.in);

      // Defining the number of cases the program will iterate and making a loop for each
      final int caseNumber = Integer.parseInt(in.nextLine());
      for (int i = 0; i < caseNumber; i++) {

         // Declaring the number of houses there are and how the trash bins are placed
         final int houses = in.nextInt();
         final String trash = in.next();
         final int[] distanceFirst = new int[houses];
         int distanceI = trash.indexOf("1");

         // Reading the String trash to define the distances
         for (int j = 0; j < houses; j++) {
            if (trash.charAt(j) == '1') {
               distanceI = j;
            }
            
            // Storing the distances in an array
            distanceFirst[j] = Math.abs(distanceI-j);
         }

         // Redefining distanceI
         distanceI = trash.lastIndexOf("1");
         Long sum = 0L;

         // Reading the string again but this time backwards to define distances
         for (int j = houses-1; j >= 0; j--) {
            if (trash.charAt(j) == '1') {
               distanceI = j;
            }

            // Getting the minimun value from the first distance and second distance
            // and adding it to sum
            distanceFirst[j] = Math.min(distanceFirst[j], Math.abs(distanceI - j));
            sum += distanceFirst[j];
         }
         System.out.printf("Case #%d: %d%n", i + 1, sum);
      }
   }
}
