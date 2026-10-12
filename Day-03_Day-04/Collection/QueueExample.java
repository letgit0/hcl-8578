package Day03.Collection;
import java.util.*;

import java.util.LinkedList;

public class QueueExample {
       public static void main(String[] args){
           Queue<Integer> q = new LinkedList<>();

           q.offer(1);
           q.offer(2);
           q.offer(3);
           q.offer(4);
           System.out.println(q);

       }
}
