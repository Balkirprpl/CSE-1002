/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Seagrass Grazing
*/

import java.util.Scanner;

public class Grazing {
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in, "US-ASCII");
      final int[][] squareTest = new int[5][5];

      // creating the grid 5 by 5 of grass
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            squareTest[i][j] = 1;
         }
      }
      
      // getting the amount of positions without grass from the stdin and defining limits
      final int amountNoGrass = in.nextInt();
      final int limitH = 20, limitL = 0;
      if (amountNoGrass <= limitL || amountNoGrass >= limitH) throw new RuntimeException();

      // removing the grass from the 5x5 grid
      for (int i = 0; i < amountNoGrass; i++) {
         final int y = in.nextInt();
         final int x = in.nextInt();
         squareTest[y - 1][x - 1] = 0;
      }

      // calling the method to get the distance from point 0,0 to 4,4 and printing it
      final int sum = getDistance(squareTest);
      System.out.println(sum);
   }


   // this method goes over the array and checks if all the squares have been eaten
   // and calls the method that iterates over the grid
   public static int getDistance (final int[][] squareTest) {
      int squaresNoGrass = 0;
      for (int y = 0; y < squareTest.length; y++) {
         for (int x = 0; x < squareTest[y].length; x++) {
            if (squareTest[y][x] == 1) squaresNoGrass++;
         }
      }
      return stepsDirections(squareTest, 0, 0, squaresNoGrass);
   }
   
   // this method iterates over the grid, going in every direction
   public static int stepsDirections (final int[][] squareTest,
         final int x, final int y, final int squaresNoGrass) {

      // if the square is an obstacle, return 0
      if (squareTest[y][x] == 0) {
         return 0;
      }

      // if y and x is the 4,4 and theres no grass left, return one, else return 0
      if (y == squareTest.length - 1 && x == squareTest[y].length - 1) {
         if (squaresNoGrass == 1) {
            return 1;
         }
         else {
            return 0;
         }
      }

      int sum = 0;

      // making the coordinate to 0
      squareTest[y][x] = 0;

      // iterating over the grid 
      for (int i = -1; i <= 1; i++) {
         for (int j = -1; j <= 1; j++) {
            final int tempX = x+j, tempY = y+i;

            if (tempX < 0 || tempY < 0 || tempY >= squareTest.length
                  || tempX >= squareTest[y].length) {
               continue;
            }

            if ((j == 0 && i == 0) || (j != 0 && i != 0)) {
               continue;
            }

            sum += stepsDirections(squareTest, x+j, y+i, squaresNoGrass-1);
         }
      }

      // making the coordinate 1 again.
      squareTest[y][x] = 1;

      return sum;
   }
}
