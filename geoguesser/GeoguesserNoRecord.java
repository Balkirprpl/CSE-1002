/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 1, Fall 2021
 * Project: Geo-guesser
*/


import java.util.Scanner;
import java.util.Random;


public class Geoguesser {   
   public static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   public static void main (final String[] args) {
      Scanner in = new Scanner(System.in);


      while (in.hasNextLine()) {
         double yGiven = in.nextDouble();
         char cy = in.next().charAt(0);
         double xGiven = in.nextDouble();
         char cx = in.next().charAt(0);
         if (cy == 'S') {
           xGiven *= -1;
         }
         if (cx == 'W') {
            yGiven *= -1;
         }
      yGiven = Math.toRadians(yGiven);
      xGiven = Math.toRadians(xGiven);

      double randomY = RNG.nextDouble();
      double randomX = RNG.nextDouble();
      int randomQuadrant = RNG.nextInt(4);
      switch (randomQuadrant) {
         case 2:
            randomX *= -1;
            break;
         case 3:
            randomY *= -1;
            randomX*= -1;
            break;
         case 4:
            randomY *= -1;
      }
      char randomCY = 'N';
      char randomCX = 'W';
      if (randomY < 0) randomCY = 'S';
      if (randomX < 0) randomCX = 'E';

      double xMelborne = Math.toRadians(-80.600000);
      double yMelborne = Math.toRadians(28.083000);

      System.out.printf("%.3f %s %.3f %s%n" , Math.abs(Math.toDegrees(randomY)), randomCY, Math.abs(Math.toDegrees(randomX)), randomCX);
      findDistance(yGiven, xGiven, randomY, randomX);
      findDistance(yGiven, xGiven, yMelborne, xMelborne);
      }
   }

   public static void findDistance(double yGiven, double xGiven, double yFind, double xFind) {
      double centralAngle = Math.acos(Math.sin(yGiven) * Math.sin(yFind)
                          + Math.cos(yGiven) * Math.cos(yFind) 
                          * Math.cos(Math.abs(xGiven - xFind)));
      double distance = 6371.009 * centralAngle;
      System.out.printf("%.2f km%n", distance);

   }
}