/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Stink
*/

// Importing the 'Random' API to create RNG
import java.util.Random;

public class Stink { 

   // Setting the use of seeds
   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   public static void main (final String[] args) {

      // Defining the number of trials the sistem will iterate
      final int trials = Integer.parseInt(args[0]);

      // Defining the limits of the program
      final int limitCeil = 1000000;
      final int limitFloor = 1;
      if (trials > limitCeil || trials < limitFloor) throw new RuntimeException();

      // Variables representing the manatees that stay or that move
      int stay = 0;
      int move = 0;

      // Loop of trials to check if the manatee was lucky or not in its choice
      for (int i = 0; i < trials; i++) {
         final int manatee = RNG.nextInt(3);
         if (manatee == 1) {
            stay++;
         }
         else {
            move++;
         }
      }

      // Printing out results
      System.out.printf("%d %d", stay, move);
   }
}
