package DataStructure;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>(); // small element will be polled first
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n2 - n1); // the largest element of the queue will be polled first
        heap.offer(3);
        heap.offer(4);
        heap.offer(2);
        heap.offer(1);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
