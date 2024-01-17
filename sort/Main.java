/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: sorting
*/

import java.lang.reflect.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
   static final long NUM = 1000000000;
   public static void main (final String[] args) throws InstantiationException,
                  IllegalAccessException, NoSuchMethodException,
                  InvocationTargetException, ClassNotFoundException {
      final Random rnd = new Random (Long.getLong ("seed", System.nanoTime()));
      long startTime, endTime, total = 0;
      final int n = Integer.parseInt(args[0]); // sized of the list
      final Class<?> clazz = Class.forName(args[1]); // getting the type of list
      final ArrayList<String> a = new ArrayList<>(n); // creating a list with size n
      @SuppressWarnings("unchecked")
      final java.util.List<Integer> list = (java.util.List<Integer>) 
            clazz.getDeclaredConstructor(java.util.Collection.class).newInstance(a);

      for (int i = 0; i < 10; i++) { // doing 10 trials
         java.util.Collections.shuffle(list, rnd); // shuffling the list
         startTime = System.nanoTime(); // starting the timer
         sort(list); // sorting the list
         endTime = System.nanoTime(); // ending the timer
         total += endTime - startTime; // adding the time to the total
      }
      final double averageTime = total / 10; // dividing the total y the amount of trials
      System.out.printf("PT%.9fS%n", averageTime / NUM); // printing
   }
   public static void sort (final List<Integer> data) {
      for (int i = 0; i < data.size(); i++) {
         /* find the min element in the unsorted data[i, i+1, .., n-1] */
         /* assume initially that min is the first element in the range */
         int min = i;
         for (int j = i + 1; j < data.size(); j++) {
            /* if the 'j'th element is less, then it is the new minimum */
            if (data.get(min) > data.get(j)) {
               /* found new minimum; remember its index */
               min = j;
            }
         }
         /* swapping */
         final int temp = data.get(min);
         data.set(min, data.get(i));
         data.set(i, temp);
      }
   }
}
