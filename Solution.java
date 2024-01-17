import java.util.Scanner;
import java.util.ArrayList;

public final class Solution {
    
   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);
      final int trials = in.nextInt();
      for (int i = 0; i < trials; i++) {
         final String input1 = in.next();
         final String input2 = in.next();
         System.out.println("Case #"+(i+1)+": "+result(input1, input2));
    
      }
   }
   public static int result (final String input1, final String input2) {
        if (input2.length() == 1) {
            final int compare = input2.charAt(0);
            int sum = 0;
            final int n = input1.length();
            for (int i = 0; i < n; i++) {
                final int temp = input1.charAt(i);
                int difference = Math.abs(temp-compare);
                if(difference>13)
                    difference=26-difference;
                sum+=difference;
            }
            return sum;
        }
        else {
            ArrayList<Character> list =new ArrayList<Character>();
            for(int i=0;i<input2.length();i++){
              list.add(input2.charAt(i));
            }
            int n=input1.length(),sum=0;
            for(int i=0;i<n;i++){
                char c=input1.charAt(i);
                if(!list.contains(c)){
                    int min=Integer.MAX_VALUE;
                    for (char s:list){
                        int temp=Math.abs(c-s);
                        if(temp>13)
                            temp=26-temp;
                        if(temp<min)
                            min=temp;
                    }
                    sum+=min;
                }
            }
            return sum;
        }
    }
}
