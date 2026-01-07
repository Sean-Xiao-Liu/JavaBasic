package LeetCode.Stack;

import java.util.Stack;

public class BaseballGameV2 {

        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack();

            for(String op : ops) {
                if (op.equals("+")) {
                    int top = stack.pop();
                    int newtop = top + stack.peek();
                    stack.push(top);
                    stack.push(newtop);
                } else if (op.equals("C")) {
                    stack.pop();
                } else if (op.equals("D")) {
                    stack.push(2 * stack.peek());
                } else {
                    // stack.push(Integer.parseInt(op));
                    stack.push(Integer.valueOf(op));// this is faster than parseInt
                }
            }

            int sum = 0;
            while (stack.size() > 0) sum+= stack.pop();
//            for(int score : stack) sum += score;//
            return sum;
        }
}
//runtime:3 ms
//memory:36.5 MB


