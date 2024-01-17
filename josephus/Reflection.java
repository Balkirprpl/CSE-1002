import java.lang.reflect.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Reflection {
   public static void main(String args[]) throws InstantiationException,
                  IllegalAccessException, NoSuchMethodException,
                  InvocationTargetException, ClassNotFoundException{
         int jumps = Integer.parseInt(args[0]);
         Class<?> clazz = Class.forName(args[1]);
         final ArrayList<String> a = new ArrayList<>();

         @SuppressWarnings("unchecked")
         final java.util.List<String> list = (java.util.List<String>) clazz.getDeclaredConstructor(java.util.Collection.class).newInstance(a);
         Scanner in = new Scanner(System.in);
         while (in.hasNext()) {
            list.add(in.next());
         }
         int index = 0;
         /*while (list.size() > 1) {
            index = (index + jumps - 1) % list.size();
            list.remove(index);
         }*/
         while(list.size() > 1){
            index = (index + jumps - 1) % list.size();
            System.out.print(list.get(index) + " ");
            list.remove(index);
        }
         System.out.println(list.get(0));
   }
}
