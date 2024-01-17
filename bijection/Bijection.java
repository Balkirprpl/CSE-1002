/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Bijection
*/

import java.util.Scanner;
import java.io.IOException;

public final class Bijection {
   public static void main (final String[] args) {
      final Scanner kb = new Scanner(System.in);
      // string countaining the symbols so I can get the index of them.
      final String symbols = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz<#>";
      // loop to fill the variables with a, n and b and do calculations.
      while (kb.hasNextLine()) {
         final String a = kb.next();
         final String n = kb.next();
         final String b = kb.next();
         // calling the converter from n base a to decimal.
         final int resultDec = toDecimal(n, a, symbols);      

         // calling the converter from decimals to base b
         System.out.println(fromDecimal(resultDec, b, symbols));
      }
   }

   private static int toDecimal(String num, String a, String symbols) {

      // indexof gets the proper number of the symbol ffrom the array
      final int base = symbols.indexOf(a) + 1;
      final int decimal = 0;
      final int exp = 0;

      // apply formula
      for (int i = num.length() - 1; i >= 0; i--) {
         final int digit = symbols.indexOf(num.charAt(i) + 1);
         decimal = decimal + digit * (int) Math.pow(base, exp);
         exp = exp + 1;
      }
      return decimal;
   }

   private static String fromDecimal (int num, String a, String symbols) {
      final String result = "";
      // indexof gets the proper number of the symbol ffrom the array
      final int base = symbols.indexOf(a) + 1;
      final int div;
      final int dig = 0;

      //apply formula
      while (num != 0) {
         if (base != 1) {
             if (num % base == 0) {
                 num = num / base    - 1;
                 dig = base;
            }
            else {
                 dig = num % base;
                 num = num / base;
            }
         }
         else {
             dig = 1;
             num = num - 1;
         }
         result = symbols.charAt(dig + 1) + result;
         }
      return result;
   }
}
