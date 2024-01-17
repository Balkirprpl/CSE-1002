/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: 2D Random Walker
*/

import java.util.Random;

public class RandomWalker { 
   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   public static void main(final String[] args) {
      int steps = Integer.parseInt(args[0]);
      int trials = Integer.parseInt(args[1]);
      int x = 0;
      int y = 0;
      int startingPosition = 0;
      double distance = 0;

      int limitCeil = 1000000;
      int limitFloor = 1;
      if (trials > limitCeil || trials < limitFloor || steps < limitFloor || steps > limitCeil) throw new RuntimeException();

      for (int k = 0; k < trials; k++){

         x =  0;
         y = 0;

         for (int i = 0; i < steps; i++){
            int direction = RNG.nextInt(4);
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
            }
            
            

         }
         if (x == 0 && y == 0) {
               startingPosition++;
            }
         distance = distance + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      }

      distance = distance/trials;

      System.out.printf("%d %.2f", startingPosition, distance);
   }
}
