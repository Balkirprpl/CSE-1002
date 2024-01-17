/*
# Author: Joao Silva, jsilva2021@my.fit.edu
# Course: CSE 1002, Fall 2021
# Project: Stock
*/

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

record DailyValues(String date, double change){}

public class Stock {
   public static void main (final String[] args) {

      // creating the scanner with the delimeters of , and /n
      final Scanner in = new Scanner(System.in).useDelimiter(",|\\n");

      final ArrayList<String> date = new ArrayList<>();
      final ArrayList<Double> closings = new ArrayList<>();
      final ArrayList<Double> change = new ArrayList<>();

      // getting all the inputs and adding them to the lists
      while (in.hasNextLine()) {
         date.add(in.next());
         if (closings.size() == 0) {
            closings.add(in.nextDouble());
         }
         else {
            final String open = in.next();
         }
         final String high = in.next();
         final String low = in.next();
         closings.add(in.nextDouble());
         final String adjclose = in.next();
         final String volume = in.next();
      }
      
      
      double bigger = 0;
      int biggerIndex = 0;
      double smaller = 0;
      int smallerIndex = 0;
      int streak = 0;

      // generating all percent change for each day and getting the smaller and bigger indexes
      for (int i = 1; i < closings.size(); i++) {
         double temp = (closings.get(i)/closings.get(i-1) * 100) - 100;
         change.add(temp); // adding all the changed to an list to check the growth later
         if (temp > bigger) {
            bigger = temp;
            biggerIndex = i-1;
         }
         if (temp < smaller) {
            smaller = temp;
            smallerIndex = i;
         }
      }

      // finding the max growth sequence in the array of changes
      int maxSequence = -1;
      int count = 0;
      int i = 0, endIndex = -1;

      for (i = 0; i < change.size(); i++) {
       if (change.get(i) > 0) {
        count++;
       } else {
        if (count > maxSequence) {
         maxSequence = count;
         endIndex = i - 1;
        }
        count = 0;
       }
      }

      if (count > maxSequence) {
       maxSequence = count;
       endIndex = i - 1;
      }

      // formatting each individual date into the form required
      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      final DateTimeFormatter formatterAns = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
      final LocalDate maxDate = LocalDate.parse(date.get(biggerIndex), formatter);
      final LocalDate minDate = LocalDate.parse(date.get(smallerIndex -1), formatter);
      final LocalDate growthFrom = LocalDate.parse(date.get(endIndex - maxSequence + 1), formatter);
      final LocalDate growthTo = LocalDate.parse(date.get(endIndex), formatter);
      

      System.out.printf("Max gain: %.2f%% on %s%nMin gain: %.2f%% on %s%n", bigger, maxDate.format(formatterAns), smaller, minDate.format(formatterAns));
      System.out.printf("Longest growth streak: %d days (%s to %s)", maxSequence, growthFrom.format(formatterAns), growthTo.format(formatterAns));
   }


}