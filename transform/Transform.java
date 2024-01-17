import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Transform {
   public static void main (final String[] args) {
      final Scanner in = new Scanner (System.in);
      int trial = in.nextInt();
      ArrayList<Long> list = new ArrayList<>();
      for (int i = 0; i < trial; i++) {
         String padlock = in.next();
         String character = in.next();
         long sum = 0;
         if (character.length() == 1) {
            for (int k = 0; k < padlock.length(); k++) {
               int temp = Math.abs(padlock.charAt(k) - character.charAt(0));
               if (temp > 13)
                     temp = 26 - temp;
               sum += temp;
            }
         }
         else {
            for (int j = 0; j < padlock.length(); j++) {
               for (int k = 0; k < character.length(); k++) {
                  long n1 = (Math.abs((padlock.charAt(j) -
                           character.charAt(k))))%13;
                  long n2 = Math.abs((padlock.charAt(j) -
                           character.charAt(k)));
                  if  (n1 != n2) list.add(13 - n1);
                  else list.add(n2);
               }
               sum += Collections.min(list);
               list.clear();
            }
         }
         System.out.printf("Case #%d: %d%n",i + 1, sum);
      }
   }
}
