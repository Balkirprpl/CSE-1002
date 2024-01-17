/*
 * Author:  J Gabriel Andrade Silva, jsilva2021@my.fit.edu
 * Course:  CSE 1002, Section 04 I guess, Fall 2021
 * Project: Proj 01, table
 */
 
public final class Table {
   public static void main (final String[] args) {
      final int n = Integer.parseInt (args[0]);

      System.out.printf ("%7s  %s  %9s%9s%9s%9s%n", "i",
               "hex", "i*i", "i*i*i", "log", "pcnt");
      for (int i = 1; i <= n; i++) {
         System.out.printf ("%,7d 0x%04X%,9d%,9d%9.3f%8d%%%n",
               i, i, i*i, i*i*i, Math.log(i*i)/Math.log(2), i*100/n);
      }
   }
}
