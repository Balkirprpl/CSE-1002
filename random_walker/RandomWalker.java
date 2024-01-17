/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: walk
*/

// Importing the 'Random' API to create RNG
import java.util.Random;

public class RandomWalker { 

   // Setting the use of seeds
   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   public static void main (final String[] args) {

      // Getting the variables of steps and trials from the user
      final int steps = Integer.parseInt(args[0]);
      final int trials = Integer.parseInt(args[1]);

      // Defining the starting position in the cartesian (2d) plane
      int x = 0;
      int y = 0;

      // Initializing the amount of times the object passes through the point (0,0)
      int startingPosition = 0;

      // Initializing the double to calculate the distance to the origin
      double distance = 0;

      // Defining the limits of the program
      final int limitCeil = 1000000;
      final int limitFloor = 1;
      if (trials > limitCeil || trials < limitFloor || steps < limitFloor
            || steps > limitCeil) throw new RuntimeException();

      // Loop of how many trials the object iterates
      for (int k = 0; k < trials; k++) {

         // Redefining the position to (0,0) after each trial
         x =  0;
         y = 0;   

         // Loop of steps done
         for (int i = 0; i < steps; i++) {

            // Getting a random number from 0 to 3
            final int direction = RNG.nextInt(4);

            // Comparing the variable direction to define where the object moves in the axis
            switch (direction) {
            case 0:
               x = x + 1;
               break;   
            case 1:
               y = y + 1;
               break;   
            case 2:
               x = x - 1;
               break;   
            case 3:
               y = y - 1;
               break;
            default:
               throw new RuntimeException();
            }
         }

         // Counting how many times the objects passes through (0,0)
         if (x == 0 && y == 0) startingPosition++;

         // Calculating the total distance and adding it
         distance = distance + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      }

      // Taking the average distance per number of trials
      distance = distance/trials;

      // Outputting results
      System.out.printf("%d %.2f", startingPosition, distance);
   }
}
