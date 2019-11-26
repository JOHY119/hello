package cloud.jony.hello;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq=new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 6, 22));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for (LocalDate date :
                pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");

        Queue<LocalDate> queue=pq;
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
//        while (!pq.isEmpty()) {
//            System.out.println(pq.remove());
//        }
    }
}
