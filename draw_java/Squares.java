/*
 * Author: Joao Gbariel Andrade Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Fun with Squares
*/

public class Squares {
   public static void main (final String[] args) {

      // getting the inputs of ratio, branching, and which pattern
      final double ratio = Double.parseDouble(args[0]);
      final int branching = Integer.parseInt(args[1]);
      final int pattern = Integer.parseInt(args[2]);

      // inititalizing the coordinates and square size
      final double x = 0.5, y = 0.5;   
      final double squareSize = 0.5;        

      // checking which pattern the program is supposed to create
      // and calling the correct method with a default case that
      // does nothing and finishes the program
      switch (pattern) {
      case 1:
         drawPattern1(branching, x, y, squareSize, ratio);
         break;

      case 2:
         drawPattern2(branching, x, y, squareSize, ratio);
         break;

      case 3:
         drawPattern3(branching, x, y, squareSize, ratio);
         break;

      case 4:
         drawPattern4(branching, x, y, squareSize, ratio);
         break;

      default:
         break;
      }
   }

   // method that creates the grey and black squares.
   public static void drawSquare (final double x, final double y, final double squareSize) {
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(x, y, squareSize/2);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, squareSize/2);
   }


   // method to create the first pattern creating every other square
   // before the middle ones by calling itself and alterating the x and y values
   public static void drawPattern1 (final int branching, final double x,
         final double y, final double squareSize, final double ratio) {
      if (branching == 0) return;

      drawPattern1(branching-1, x + squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);   

      drawPattern1(branching-1, x - squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);  

      drawPattern1(branching-1, x - squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio); 

      drawPattern1(branching-1, x + squareSize/2, y
            + squareSize/2, squareSize/ratio, ratio);

      drawSquare(x, y, squareSize);
   }
   \
    
      awsxeeedrrrftt6t6t

   // method to create the second pattern creating every other square
   // before the lower right one by calling itself and alterating the x and y values
   public static void drawPattern2 (final int branching, final double x,
         final double y, final double squareSize, final double ratio) {
      if (branching == 0) return;

      drawPattern2(branching-1, x - squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio); 

      drawPattern2(branching-1, x - squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);

      drawPattern2(branching-1, x + squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);

      drawSquare(x, y, squareSize);

      drawPattern2(branching-1, x + squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);
   }

   // method to create the third pattern creating first thee square
   // then calling to make the other squares by calling itself
   // and alterating the x and y values
   public static void drawPattern3 (final int branching, final double x,
         final double y, final double squareSize, final double ratio) {
      if (branching == 0) return;

      drawSquare(x, y, squareSize);

      drawPattern3(branching-1, x + squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);

      drawPattern3(branching-1, x - squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);  

      drawPattern3(branching-1, x - squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);  

      drawPattern3(branching-1, x + squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);
   }

   // method to create the fourth pattern creating every other square
   // before the bottom ones by calling itself and alterating the x and y values;
   public static void drawPattern4 (final int branching, final double x,
         final double y, final double squareSize, final double ratio) {
      if (branching == 0) return;

      drawPattern4(branching-1, x - squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);

      drawPattern4(branching-1, x + squareSize/2,
            y + squareSize/2, squareSize/ratio, ratio);

      drawSquare(x, y, squareSize);

      drawPattern4(branching-1, x + squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio);

      drawPattern4(branching-1, x - squareSize/2,
            y - squareSize/2, squareSize/ratio, ratio); 

   }

}
