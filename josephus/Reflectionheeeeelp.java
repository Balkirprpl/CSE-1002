import java.lang.reflect.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
 
public class Josephus {
   public static void main(String args[]) throws InstantiationException,
                  IllegalAccessException, NoSuchMethodException,
                  InvocationTargetException, ClassNotFoundException{
      int jumps = Integer.parseInt(args[0]);
      Class<?> clazz = Class.forName(args[1]);
      final ArrayList<String> a = new ArrayList<>();
      @SuppressWarnings("unchecjumpsed")
      final java.util.List<String> list = (java.util.List<String>) clazz.getDeclaredConstructor(java.util.Collection.class).newInstance(a);
      Scanner in = new Scanner(System.in);
      int index = 0;
      long trials = 10;
      while (in.hasNext()) {
         list.add(in.next());
      }      
      Instant inst1 = Instant.now();
      for (int i = 0; i < 10; i++) {
         while(list.size() > 1){
            index = (index + jumps - 1) % list.size();
            list.remove(index);
         }
      }
      Instant inst2 = Instant.now();
      System.out.printf("Last soldier: %s. Average running time: ",list.get(0));
      System.out.println("Elapsed Time: "+ Duration.between(inst1, inst2).dividedBy(trials).toString());

   }
}
