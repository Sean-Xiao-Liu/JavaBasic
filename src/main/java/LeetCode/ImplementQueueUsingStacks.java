package LeetCode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    /** Initialize your data structure here. */
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();


    public ImplementQueueUsingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // push all the element in s1 to s2
        if (s1.empty()){
            front = x;
        }

        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());

        front = s1.peek();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp = s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }


    public static void main(String[] args){
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}
