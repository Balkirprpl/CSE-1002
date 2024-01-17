/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Mortgage
*/


import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Mortgage {
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);
      String input = in.next();
      BigDecimal loan = new BigDecimal(input);
      input = in.next();
      final BigDecimal interestRate = new BigDecimal(input);
      while (in.hasNextLine()) { // continues receiving inputs until the end of file
         input = in.next();
         if (input.toLowerCase().equals("balance")) { // checks if the input is "balance"
            if (loan.doubleValue() > 0) {
               System.out.printf("balance: %.2f left%n", loan);
            }
            if (loan.doubleValue() < 0) {
               System.out.printf("balance: %.2f over%n", loan.abs());
            }
            if (loan.doubleValue() == 0) {
               System.out.printf("balance: %.2f%n", loan);
            }
         }
         else if (loan.intValue() >= 0 || loan.intValue() < 0) { // checks if input is number
            loan = loan.add(loan.multiply(interestRate)); // apply interest rate to balance
            final BigDecimal temp = new BigDecimal(input); // create a temporary variable 
            loan = loan.subtract(temp); // subtract the input from the total
            loan = loan.setScale(2, RoundingMode.HALF_UP); // round up the total
         }
      }
   }
}
