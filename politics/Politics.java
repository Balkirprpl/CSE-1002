/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Politics
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class Politics {
   record InputObj(String sup, String cand) {} 
   public static void main (final String[] args) {
      final ArrayList<String> candidates = new ArrayList<>();
      final ArrayList<InputObj> supporters = new ArrayList<>();
      final Scanner in = new Scanner(System.in);
     // Duration<Long> sum = new Duration<>();
      long trials = 0;
      int n = in.nextInt();
      int m = in.nextInt();
      Instant inst1 = Instant.now();
      while (m != 0 && n != 0) { // checking if the number inputs are valid
         // creating and filling a list with the n candidates
         for (int i = 0; i < n; i++) {
            final String tempCandidates = in.next();
            candidates.add(tempCandidates);
         }
         // creating and filling the list with the m supporters and adding a new candidate
         // in case they're not already in the candidates list
         for (int i = 0; i < m; i++) {
            final String tempSupporter = in.next();
            final String tempCandidates = in.next();
            if (candidates.indexOf(tempCandidates) == -1) {
               final InputObj a = new InputObj(tempSupporter, tempCandidates);
               supporters.add(a);
               candidates.add(tempCandidates);
            }
            else {
               final InputObj a = new InputObj(tempSupporter, tempCandidates);
               supporters.add(a);
            }
         }
         // iterating through the all the possible options and printing
         // the ones that match candidates in order
         for (int i = 0; i < candidates.size(); i++) {
            for (int j = 0; j < supporters.size(); j++) {
               if (candidates.get(i).equals(supporters.get(j).cand)) {
                  System.out.println(supporters.get(j).sup);
               }
            }
         }
      
         // clearing lists to the next iteration
         candidates.clear();
         supporters.clear();
         n = in.nextInt();
         m = in.nextInt();
         trials++;
      }
      Instant inst2 = Instant.now(); 
      //sum.plus(Duration.between(inst1, inst2));
      System.out.println("Elapsed Time: "+ Duration.between(inst1, inst2).dividedBy(trials).toString());
   }
}
