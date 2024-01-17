/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Seagrass Grazing
*/

import java.util.Scanner;

public class Grazing3 {
   public static void main (final String[] args) {
      Scanner in = new Scanner(System.in, "US-ASCII");
      final int[][] squareTest = new int[5][5];

      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            squareTest[i][j] = 1;
            System.out.print(" " + squareTest[i][j] + " ");
         }
         System.out.println("");
      }
      int amountNoGrass = in.nextInt();
      
      if (amountNoGrass <= 0 || amountNoGrass >= 22) throw new RuntimeException();

      for (int i = 0; i < amountNoGrass; i++) {
         int y = in.nextInt();
         int x = in.nextInt();
         squareTest[y - 1][x - 1] = 0;
      }

      System.out.println("");
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            System.out.print(" " + squareTest[i][j] + " ");
         }
         System.out.println("");
      }
      
      System.out.println("");
      int x = 0;
      int y = 0;
      int sum = squareCount(squareTest, y, x);
      System.out.println(sum);
   }

   public static int squareCount(final int[][] squareTest, int y, int x) {
      int sum = 0;
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            System.out.print(" " + squareTest[i][j] + " ");
         }
         System.out.println("");
      }
      System.out.println("");
      if ((x + 1) < 5 && squareTest[y][x + 1] == 1) {
         squareTest[y][x] = 2;
         sum += squareCount(squareTest, y, x + 1);
      } 
      if ((y + 1) < 5 && squareTest[y + 1][x] == 1) {
         squareTest[y][x] = 2;
         sum += squareCount(squareTest, y + 1, x);
      }
      if ((x - 1) > - 1 && squareTest[y][x - 1] == 1) {
         squareTest[y][x] = 2;
         sum += squareCount(squareTest, y, x - 1);
      }
      if ((y - 1) > - 1 && squareTest[y - 1][x] == 1) {
         squareTest[y][x] = 2;
         sum += squareCount(squareTest, y - 1, x);
      }
      int check = 0;
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            System.out.print(" " + squareTest[i][j] + " ");
         }
         System.out.println("");
      }
      System.out.println("");
      if (check == 0) {
         return 1;
      }
      else {
         return 0;
      }
   }
}