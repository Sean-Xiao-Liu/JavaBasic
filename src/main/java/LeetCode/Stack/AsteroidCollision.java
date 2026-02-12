package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * Example 1:
 * 
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
 * collide.
 * 
 * Example 2:
 * 
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * 
 * Example 3:
 * 
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide
 * resulting in 10.
 * 
 * Example 4:
 * 
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i : asteroids) {
            if (i > 0) {
                stack.add(i);
            } else {
                // if number is negative, need to keep compare it with the positive number in
                // stack
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i) {
                    stack.pop();
                }

                // if stack.peek() > i, do nothing

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.add(i);
                }

                // this can't go first since stack.peek() might be null
                if (stack.peek() == -i) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.get(i);
        }

        return res;
    }

    // int[] array as stack: avoids boxing/unboxing and synchronization overhead
    public int[] asteroidCollision2(int[] asteroids) {
        int[] stack = new int[asteroids.length]; // use int array as stack
        int top = -1; // top pointer, -1 means empty

        for (int cur : asteroids) {
            if (cur > 0) {
                stack[++top] = cur;
            } else {
                // keep popping smaller positive asteroids
                while (top >= 0 && stack[top] > 0 && stack[top] < -cur) {
                    top--;
                }

                if (top >= 0 && stack[top] == -cur) {
                    // equal size, both explode
                    top--;
                } else if (top < 0 || stack[top] < 0) {
                    // stack empty or top is also negative, push current
                    stack[++top] = cur;
                }
                // otherwise stack[top] > -cur, current asteroid destroyed, do nothing
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}
