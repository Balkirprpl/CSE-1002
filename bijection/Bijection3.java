/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Bijection
*/

import java.util.Scanner;
import java.io.IOException;

public final class Bijection3 {
   public static void main (final String[] args) {
      final Scanner kb = new Scanner(System.in);
      String symbols = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz<#>";
      while (kb.hasNextLine) {
      String a = kb.next();
      String n = kb.next();
      String b = kb.next();
      int resultDec = toDecimal(n, a, symbols);
      
      
      System.out.println(resultDec);
      System.out.println(fromDecimal(resultDec, b, symbols));
      }
   }

   //Converts a number in a given base to decimal number i.ie base 10
    private static int toDecimal(String num, String a, String symbols) {
        //gets actual value of b(base) example A=10,B=11..............'>' = 64
        int base = symbols.indexOf(a) + 1;
        int decimal = 0;
        int exp = 0;

        for (int i = num.length() - 1; i>= 0; i--) {
            int digit = symbols.indexOf(num.charAt(i) + 1);
            decimal = decimal + digit * (int) Math.pow(base, exp);
            exp = exp + 1;
        }
        return decimal;
    }

    // will convert the number into the given base
    private static String fromDecimal(int num, String b String symbols) {
        String result = "";
        //gets actual value of b(base) example A=10,B=11..............'>' = 64
        int base = symbols.indexOf(b) + 1;
        int remainder;
        while ()
            result = symbols.indexOf((dig)) + result;
        }
        return result;
    }
}
