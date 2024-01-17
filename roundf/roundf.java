import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class roundf {
   public static void main (String[] args) {
      Scanner scanner = new Scanner (System.in);

      int cases = scanner.nextInt();
      int distance = 0;
      for (int i = 0; i < cases; i++) {
         int houses = scanner.nextInt();
         String trash = scanner.next();
         int count = 0;
         int right = 0;
         int left = 0;
         int[] compare1 = new int[houses];
         int[] compare2 = new int[houses];


         for (int j = houses - 1; j >= 0; j--) {
            if (trash.charAt(j) == '0') {
               left = 0;
               for (int k = j; k > 0; k--) {
                  if (trash.charAt(k) == '0') {
                     left++;
                  }
                  else {
                     k = 0;
                  }
                  compare1[j] = left;
               }
            }
            else {
               left = 0;
            }
         }
         System.out.println("---------------");
         for (int j = 0; j < houses; j++) {
            if (trash.charAt(j) == '0') {
               right = 0;
               for (int k = j; k < houses; k++) {
                  if (trash.charAt(k) == '0') {
                     right++;
                  }
                  else {
                     right = 0;
                  }
                  compare2[j] = right;
               }
            }
            else {
               right = 0;
            }
         }
      System.out.println(Arrays.toString(compare1));
      System.out.println(Arrays.toString(compare2));
      }
   }
}