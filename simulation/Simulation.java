/*
 * Author: Joao "Gabriel" Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Predator-Prey Simulation
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Simulation {
   final static Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   public static void main (final String[] args) {
      int size = Integer.parseInt(args[0]);
      int iterations = Integer.parseInt(args[1]);
      String[][] grid = new String[size][size];
      for (int i = 0; i < size; i++) {
         grid[0][i] = ".";
         grid[i][0] = ".";
         grid[size - 1][i] = ".";
         grid[i][size - 1] = ".";
      }
      for (int i = 1; i < size - 1; i++) {
         for (int j = 1; j < size - 1; j++) {
            final double x = RNG.nextDouble();
            if (x < 0.1) grid[i][j] = "X";
            else if (x < 0.3) grid[i][j] = "R";
            else if (x < 0.6) grid[i][j] = "G";
            else grid[i][j] = ".";
         }
      }
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
         System.out.print(grid[i][j]);
         }
         System.out.println();
      }
   }
}