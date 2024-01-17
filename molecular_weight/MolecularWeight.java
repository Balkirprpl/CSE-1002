/*
 * Author: name, e-mail address
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: Molecular Weight
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;



public class MolecularWeight {
   // creating a record for each element in the table provided
   record Element(String symbol, Double weight) {} 

   public static void main (final String[] args) throws FileNotFoundException {
      final Scanner in = new Scanner(System.in);
      final ArrayList<Element> arr = new ArrayList<>();
      final String fileName = args[0]; // getting the name of the file to be imported
      final File text = new File(fileName);
      final Scanner file = new Scanner(text, "US-ASCII").useDelimiter(",");

      String trash = "";
      String symbol = "";
      Double molecularWeight = 0.0;
      
      trash = file.nextLine(); // getting rid of the first line from the elemets.csv

      // this while loop gets only the symbol for the elements and their weight
      // and throws everything else in the trash
      // then the objects created is added to the array list.
      while (file.hasNextLine()) {
         trash = file.next(); 
         trash = file.next(); 
         symbol = file.next();
         molecularWeight = file.nextDouble();
         trash = file.nextLine();
         final Element a = new Element(symbol, molecularWeight);
         arr.add(a);
      }

      while (in.hasNextLine()) {
         // getting the input and splitting it into sections
         final String wholeline = in.nextLine();
         final String[] line = wholeline.split(" ");
         boolean exists = true;
         double finalMass = 0;
         int i;
         for (i = 0; i < line.length; i++) { // iterating over the input
            String second;
            double mass = 0;
            final String element = line[i]; // getting the first element of the line
            for (int j = 0; j < arr.size(); j++) { 
               // finding the element inside the arraylist and getting it's weight
               if (arr.get(j).symbol.equals(element)) {
                  mass = arr.get(j).weight;
                  break;
               }
               // if the element is not inside, set the mass to a negative 
               // number so it can be checked later
               else { 
                  mass = -1;
               }
            }
            if (mass == -1) exists = false; // checking if the number exists in the list
            try { // getting the second input 
               second = line[i+1];
            }
            catch (ArrayIndexOutOfBoundsException e) {
               second = "not a number";
            }
            // checking if the second input is a number, multiplying by the mass and adding
            // to the total
            try {
               final double moleculeAmount = Double.parseDouble(second);
               finalMass += mass*moleculeAmount;
               i += 1;
            }
            // just adding the mass to the total mass if its not a number
            catch (IllegalArgumentException e) {
               finalMass += mass;
            }
         }
         if (exists) {
            System.out.printf("Molecular weight of %s = %.2f%n", wholeline, finalMass);
         }
         else {
            System.out.printf("Molecular weight of %s = ??%n", wholeline);
         }
      }

   }
}
