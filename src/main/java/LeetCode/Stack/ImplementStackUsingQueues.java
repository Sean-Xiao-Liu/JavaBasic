package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private int top;
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();



    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {

        // make sure the new added number x is always at the front
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        //swap q1 and q2 to make sure the q2 is always an empty queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp = q1.poll();
        if(!q1.isEmpty()) top = q1.peek();
        return temp;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
