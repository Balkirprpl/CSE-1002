/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 1, Fall 2021
 * Project: Geo-guesser
*/


import java.util.Scanner;
import java.util.Random;


public class Geoguesser {

   public static class Point {
      Point(){}
      Point(double givenY, double givenX) {
         this.x = givenX;
         this.y = givenY;
      }
      double x, y;
   }
   // defining the random object
   public static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));

   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);
         /*
          * This first part of the code gets the inputs, 
          * checks the quadrant it is in and creates an object
          * with the name "given" with the y and x coordinates inside of it
         */

         System.out.println("Input coordinate (Ycoord + (N/S) + Xcoord + (W/E))");

         double yGiven = in.nextDouble();
         final char cy = in.next().charAt(0);
         double xGiven = in.nextDouble();
         final char cx = in.next().charAt(0);
         if (Character.toUpperCase(cy) == 'S') {
            xGiven *= -1;
         }
         if (Character.toUpperCase(cx) == 'W') {
            yGiven *= -1;
         }
         yGiven = Math.toRadians(yGiven);
         xGiven = Math.toRadians(xGiven);

         final Point given = new Point(yGiven, xGiven);
         
         // ---------------------------- end of the first section ---------------------------- 
         
         /*
          * This second section creates random numbers from 0 to 1, 
          * and puts it inside one quadrant randomly from 1 to 4.
          * then it creates and object called "random" with the 
          * y and x coordinates inside of it.
         */
         double randomY = RNG.nextDouble();
         double randomX = RNG.nextDouble();
         final int randomQuadrant = RNG.nextInt(4);
         switch (randomQuadrant) {
         case 2:
            randomX *= -1;
            break;
         case 3:
            randomY *= -1;
            randomX *= -1;
            break;
         case 4:
            randomY *= -1;
            break;
         default:
            break;
         }
         char randomCY = 'N';
         char randomCX = 'W';
         if (randomY < 0) randomCY = 'S';
         if (randomX < 0) randomCX = 'E';

         final Point random = new Point(randomY, randomX);

         // --------------------------- end of the second section --------------------------- 

         /*
          * This third section creates an object with
          * the coordinates of melbourne given in the task.
         */
         final double xmelbourne = Math.toRadians(-80.600000);
         final double ymelbourne = Math.toRadians(28.083000);

         final Point melbourne = new Point(ymelbourne, xmelbourne);

         // ---------------------------- end of the third section ---------------------------- 


         // call the method to calculate and print the distance
         // between the point given and melbourne.
         findDistance(given.y, given.x, melbourne.y, melbourne.x);
         in.close();
   }

   public static void findDistance (final double yGiven,
         final double xGiven, final double yFind, final double xFind) {
      final double centralAngle = Math.acos(Math.sin(yGiven) * Math.sin(yFind)
                          + Math.cos(yGiven) * Math.cos(yFind) 
                          * Math.cos(Math.abs(xGiven - xFind)));
      final double distance = 6371.009 * centralAngle;
      System.out.printf("%.2f km from Melbourne%n", distance);
   }
}
