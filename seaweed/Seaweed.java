/*
 * Author: Joao "Gabriel" Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Seaweed disease research
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public final class Seaweed {
   // arraylist of manatees
   static ArrayList<Manatee> arr = new ArrayList<>();
   private Seaweed () {}  // Prevent the instantiation of this utility class!
   // creating the record and implementing the 
   // Comparable interface in order to sort it later.
   record Manatee (int t, int d) implements Comparable<Manatee> {
      @java.lang.Override
      public int compareTo (final Manatee other) {
         final int temp1 = this.t * other.d;
         final int temp2 = this.d * other.t;
         return temp1 - temp2;
      }
   }

   public static void main (final String[] args) {
      final Scanner in = new Scanner(System.in);
      final int n = in.nextInt();
      for (int i = 0; i < n; i++) { // getting all the inputs and putting them in the list
         arr.add(new Manatee(in.nextInt(), in.nextInt()));
      }
      Collections.sort(arr); // sorting the list
      long time = 0; // getting the time needed to get to each manatee
      long seaweedate = 0; // total of seaweed eaten
      for (int i = 0; i < n; i++) { // getting the amount of seaweed eaten by each manaatee 
         seaweedate += arr.get(i).d * time * 2;
         time += arr.get(i).t; // incrementing the time to get to the next manatee
      }
      System.out.println(seaweedate);
   }
}
