/* 
* Author:  Zealand Brennan, abrennan2021@my.fit.edu
* Course:  CSE 1002
* Project: Geo-guesser
*/

import java.util.Scanner;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class GeoguesserZ    {

   // random number generator
   public static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));

   // records
   public record Map (double latitute, String nORs, 
         double longitude, String eORw) {}

   // method calculates distance between input and Melbourne
   public static void locationMelbourne (final double lat, final double lon) {

      final double x1 = Math.toRadians(lon); // convert lon to radians
      final double y1 = Math.toRadians(lat); // convert lat to radians
      final double x2 = Math.toRadians(-80.600000); // converts Melbourne longitute to radians
      final double y2 = Math.toRadians(28.083000); // converts Melbourne latitude to radians

      // calculations to find great circle distance
      final double dlon = x2 - x1; 
      final double dlat = y2 - y1;

      final double calc1 = Math.pow(Math.sin(dlat / 2), 2)
                 + Math.cos(y1) * Math.cos(y2)
                 * Math.pow(Math.sin(dlon / 2), 2);

      final double calc2 = 2 * Math.asin(Math.sqrt(calc1));

      final double distance1 = calc2 * 6371.009;

      // convert to big decimal for precise rounding
      BigDecimal disBig = BigDecimal.valueOf(distance1);
      disBig = disBig.setScale(2, RoundingMode.DOWN);

      // print results
      System.out.printf("%.2f km %n", disBig); 
   }

    // method calculates distance between input and random number
   public static void locationRandom (final double lat, final double lon) {

      final double x1 = Math.toRadians(lon); // convert lon to radians
      final double y1 = Math.toRadians(lat); // convert lat to radians
      final double x2 = Math.toRadians(RNG.nextDouble()); // converts random number to radians
      final double y2 = Math.toRadians(RNG.nextDouble()); // converts random number to radians

      // calculations to find great circle distance
      final double dlon2 = x2 - x1;
      final double dlat2 = y2 - y1;

      final double calc3 = Math.pow(Math.sin(dlat2 / 2), 2)
                 + Math.cos(y1) * Math.cos(y2)
                 * Math.pow(Math.sin(dlon2 / 2), 2);

      final double calc4 = 2 * Math.asin(Math.sqrt(calc3));

      final double distance2 = calc4 * 6371.009;

      // convert to big decimal for precise rounding
      BigDecimal disBig2 = BigDecimal.valueOf(distance2);
      disBig2 = disBig2.setScale(2, RoundingMode.DOWN);
    
      // print results
      System.out.printf("%.2f km %n", disBig2); 
   }

   public static void main (final String[] args) {
    
      final Scanner input = new Scanner(System.in); 

      while (input.hasNext()) {

         double lat = input.nextDouble(); // get latitude
         final String nORs = input.next(); // north or south
         double lon = input.nextDouble(); // get longitute
         final String eORw = input.next(); // east or west

         final Map information = new Map (lat, nORs, lon, eORw); // record

         // if latitude is S then make it negative
         if (nORs.equals("S")) {
            lat = (lat * -1);
         }
         // if longitute is W then make it negative
         if (eORw.equals("W")) {
            lon = (lon * -1);
         }
         // find distances for Random number and Melbourne
         locationRandom(lat, lon);
         locationMelbourne(lat, lon);
      }
   }
}
