/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Messenger
*/

import java.util.Scanner;

public class Messenger {
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);
      int path1 = in.nextInt();
      int[] x1 = new int[path1];
      int[] y1 = new int[path1];
      for (int i = 0; i < path1; i++) {
         x1[i] = in.nextInt();
         y1[i] = in.nextInt();
      }

      int path2 = in.nextInt();
      int[] x2 = new int[path2];
      int[] y2 = new int[path2];
      for (int i = 0; i < path2; i++) {
         x2[i] = in.nextInt();
         y2[i] = in.nextInt();
      }

   }
}
