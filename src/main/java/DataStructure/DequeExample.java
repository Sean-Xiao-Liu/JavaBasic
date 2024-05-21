package DataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<Integer>();

        deque.addFirst(5);
        deque.addFirst(10);
        deque.addFirst(15);
        System.out.println(deque.getLast());

    }
}
