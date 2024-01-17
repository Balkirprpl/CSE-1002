/*
 * Author: Joao "Gabriel" Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Predator-Prey Simulation
*/

import java.util.Random;

public class Simulation {
   static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   static final double FOX = 0.1;
   static final double RABBIT = 0.3;
   static final double GRASS = 0.6;
   public static void main (final String[] args) {
      final int size = Integer.parseInt(args[0]);
      final int iterations = Integer.parseInt(args[1]);
      String[][] grid = new String[size][size];
      final String[][] newGrid = new String[size][size];
      final int[][] repetition = new int[size][size];
      for (int i = 0; i < size; i++) {
         grid[0][i] = ".";
         newGrid[0][i] = ".";
         grid[i][0] = ".";
         newGrid[i][0] = ".";
         grid[size - 1][i] = ".";
         newGrid[size - 1][i] = ".";
         grid[i][size - 1] = ".";
         newGrid[i][size - 1] = ".";
      }
      for (int i = 1; i < size - 1; i++) {
         for (int j = 1; j < size - 1; j++) {
            final double x = RNG.nextDouble();
            if (x < FOX) {
               grid[i][j] = "X";
               newGrid[i][j] = "X";
            }
            else if (x < RABBIT) {
               grid[i][j] = "R";
               newGrid[i][j] = "R";
            }
            else if (x < GRASS) {
               grid[i][j] = "G";
               newGrid[i][j] = "G";
            }
            else {
               grid[i][j] = ".";
               newGrid[i][j] = ".";
            }
         }
      }

      for (int k = 0; k <= iterations; k++) {
         System.out.printf("Cycle = %d%n", k);
         printArray(newGrid);
         System.out.printf("%n");

         for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
               // A fox starves if surrounded by over 5 other foxes
               // or if there are no rabbits nearby; a fox dies after 5 world-cycles
               if (grid[i][j].equals("X") && (checkNeighborhood(grid, "X", i, j) >= 5)
                     || (repetition[i][j] == 5)
                     || (checkNeighborhood(grid, "R", i, j) == 0)) {
                  newGrid[i][j] = ".";
                  repetition[i][j] = 0;
               }
               // A rabbit starves if there is no grass nearby or if there are more
               // or equal numbers of foxes than rabbits nearby;
               // a rabbit dies after 3 world-cycles;
               if (grid[i][j].equals("R") && (checkNeighborhood(grid, "G", i, j) == 0
                        || checkNeighborhood(grid, "R", i, j)
                           <= checkNeighborhood(grid, "X", i, j)
                        || repetition[i][j] == 3)) {
                  newGrid[i][j] = ".";
                  repetition[i][j] = 0;
               }
               // Grass is replaced by a new rabbit if grass
               // nearby totals more than twice the number of rabbits nearby;
               // and if grass nearby is more than rabbits nearby 
               // then it remains else it dies out.
               if (grid[i][j].equals("G") && checkNeighborhood(grid, "G", i, j)
                        >= 2 * checkNeighborhood(grid, "R", i, j)
                        && checkNeighborhood(grid, "R", i, j) != 0) {
                  newGrid[i][j] = "R";
                  repetition[i][j] = 0;
               }
               if (grid[i][j].equals("G") && checkNeighborhood(grid, "G", i, j)
                        < checkNeighborhood(grid, "R", i, j)) {
                  newGrid[i][j] = ".";
                  repetition[i][j] = 0;
               }
               // An empty square produces a new fox if more than two rabbits are nearby;
               // else a new rabbit if more than four grass squares are nearby;
               // else some new grass if there is any grass nearby.
               if (grid[i][j].equals(".") && checkNeighborhood(grid, "R", i, j) > 2) {
                  newGrid[i][j] = "X";
                  repetition[i][j] = 0;
               }
               if (grid[i][j].equals(".") && checkNeighborhood(grid, "G", i, j) > 0) {
                  newGrid[i][j] = "G";
                  repetition[i][j] = 0;
               }
               if (grid[i][j].equals(newGrid[i][j])) repetition[i][j]++;
            }
         }
         grid = cloneArray(newGrid); // cloning the old array into a new one
      }      
   }
   // method to print the array
   static void printArray (final String[][] grid) { 
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid.length; j++) {
            System.out.print(grid[i][j]);
         }
         System.out.println();
      }
   }
   // method to check they neighborhoods "find" of a point
   static int checkNeighborhood (final String[][] gridChecking,
            final String find, final int positionX, final int positionY) {
      int count = 0;
      for (int i = positionX - 1; i <= positionX + 1; i++) {
         for (int j = positionY - 1; j <= positionY + 1; j++) {
            if (positionX == i && j == positionY) {
               count = count;
            }
            else {
               if (gridChecking[i][j].equals(find)) count++;
            }
         }
      }
      return count;
   }
   // method to clone the array
   static String[][] cloneArray (final String[][] array) {
      final String[][] clone = new String[array.length][array.length];
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array.length; j++) {
            clone[i][j] = array[i][j];
         }
      }
      return clone;
   }
}
