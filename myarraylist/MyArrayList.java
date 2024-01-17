/*
 * Author: Joao Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Fall 2021
 * Project: My ArrayList
*/

public class MyArrayList extends MyListInterface {
   // Making size and the Integer array private so the user do not control them
   private int size;
   private Integer[] list;
   
   // Constructs an empty list with an initial capacity of 10
   public MyArrayList() {
      this(10);
   }

   // Constructs an empty list with the specified initial capacity
   public MyArrayList (final int initialCapacity) {
      list = new Integer[initialCapacity];
   }

   // Increases the capacity of the array, if necessary, to ensure that
   // it can hold at least the number of elements specified by the argument
   private void ensureCapacity (final int minCapacity) {
      final int currentCapacity = list.length;
      if (minCapacity > currentCapacity) {
         final Integer[] tempList = new Integer[Math.max(currentCapacity * 2, minCapacity)];
         System.arraycopy(list, 0, tempList, 0, size);
         list = tempList;
      }
   }

   // Inserts the specified element at the end of the list, return true if it succeeded
   @Override
   public boolean add (final Integer element) {
      if (size == list.length) ensureCapacity(size + 1);
      list[size++] = element;
      return true;
   }

   // Returns the element at the specified position in this list
   @Override
   public Integer get (final int index) {
      checkOutOfBounds(index);
      return list[index];
   }

   // Replaces the element at the specified position in this list,
   // should return the removed element value
   @Override
   public Integer set (final int index, final Integer element) {
      checkOutOfBounds(index);
      final Integer valueInd = list[index];
      list[index] = element;
      return valueInd;
   }

   // Removes the element at index specified by the argument, return the removed element value.
   @Override
   public Integer remove (final int index) {
      checkOutOfBounds(index);
      final Integer removedNumber = list[index];
      if (index != --size) {
         System.arraycopy(list, index + 1, list, index, size - index);
      }
      list[size] = null;
      return removedNumber;
   }

   // Find and Remove the first occurrence of the
   // specified element from this list, if it is present.
   @Override
   public boolean remove (final Integer element) {
      for (int i = 0; i < size; i++) {
         if (list[i] == element) { // checking if the element exists
            remove(i); // removing the element at the index
            return true; // returning true 
         }
      }
      return false; // if the element is not in the list, returns false
   }

   // Returns the number of elements in this list
   @Override
   public int size () {
      return size;
   }

   // Removes all of the elements from this list.
   @Override
   public void clear () {
      if (size > 0) {
         java.util.Arrays.fill(list, 0, size, null);
         size = 0;
      }
   }

   // checking if the number provided is a possible index of the list
   private void checkOutOfBounds (final int index) {
      if (index >= size) throw new IndexOutOfBoundsException();
   }

   // creating a string with all the values of the array
   @Override
   public String toString () {
      String outString = "[";
      String s;
      for (int i = 0; i < size; i++) {
         s = outString + String.valueOf(list[i]);
         if (list[i + 1] != null) s = s + " - ";
         outString = s;
      }
      outString = outString + "]";
      return outString;
   }
}
