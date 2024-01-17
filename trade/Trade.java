/*
* Author:  J Gabriel Andrade Silva, jsilva2021@my.fit.edu
* Course:  CSE 1002, Section 04 I guess, Fall 2021
* Project: Volitility
*/
import java.util.Scanner;

public final class Trade {
   public static void main (final String[] args) {
      final Scanner kb = new Scanner(System.in);
      int money = 100;
      final int maxDays = 365;
      final int[] dayprice = new int[maxDays];
      int shares = 0;

      for (int i = 1; kb.hasNextInt(); i++) {
         dayprice[i] = kb.nextInt();
         if (money >= dayprice[i] && (i % 2 == 1)) {
            while (dayprice[i] <= money) {
               money = money - dayprice[i];
               shares++;
            }
         }
         else if (shares >= 1) {
            while (shares >= 1) {
               money = money + dayprice[i];
               shares--;
            }
         }
      }
      System.out.println(money);
   }
}
