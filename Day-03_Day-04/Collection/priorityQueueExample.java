package Day03.Collection;

import java.util.PriorityQueue;

public class priorityQueueExample {
    public static void  main(String[] args){
        PriorityQueue<Integer> pq  = new PriorityQueue<>();

        pq.add(10);
        pq.add(12);
        pq.add(15);
        pq.add(17);
        pq.add(19);

        while(!pq.isEmpty()){
            System.out.println(pq.poll() + "");
        }

    }
}
