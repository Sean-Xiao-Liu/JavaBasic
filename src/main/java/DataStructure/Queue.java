package DataStructure;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
        java.util.Queue<Integer> queue1 = new LinkedList<>(); // Queue is an interface
        java.util.Queue<Character> queue2 = new PriorityQueue<>();

        queue1.add(1);
        queue1.offer(2);
        System.out.println(queue1.poll());
        System.out.println(queue1.peek());


    }
}
