package LeetCode;

//
//You're now a baseball game point recorder.
//
//
//
//Given a list of strings, each string can be one of the 4 following types:
//
// Integer (one round's score): Directly represents the number of points you get in this round.
// "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
// "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
// "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
//
//
//
//
//Each round's operation is permanent and could have an impact on the round before and the round after.
//
//
//
//You need to return the sum of the points you could get in all the rounds.
//
//
// Example 1:
//
//Input: ["5","2","C","D","+"]
//Output: 30
//Explanation:
//Round 1: You could get 5 points. The sum is: 5.
//Round 2: You could get 2 points. The sum is: 7.
//Operation 1: The round 2's data was invalid. The sum is: 5.
//Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
//Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
//
//
//
// Example 2:
//
//Input: ["5","-2","4","C","-4","9","+","+"]
//Output: 27
//Explanation:
//Round 1: You could get 5 points. The sum is: 5.
//Round 2: You could get -2 points. The sum is: 3.
//Round 3: You could get 4 points. The sum is: 7.
//Operation 1: The round 3's data is invalid. The sum is: 3.
//Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
//Round 5: You could get 9 points. The sum is: 8.
//Round 6: You could get -4 + 9 = 5 points. The sum is 13.
//Round 7: You could get 9 + 5 = 14 points. The sum is 27.
//
//
//
// Note:
// The size of the input list will be between 1 and 1000.
// Every integer represented in the list will be between -30000 and 30000.
//

import java.util.Stack;

public class BaseballGame {

    private static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < ops.length; i++) {
            try {
                int num = Integer.parseInt(ops[i]);
                stack.push(num);
            }

            catch (Exception e) {
                if(ops[i] == "C"){
                    System.out.println("C means cancel");
                    stack.pop();// remove the last score from the stack
                }

                if(ops[i] == "D"){
                    System.out.println("D means double");
                    int doubleScore = stack.peek() * 2;
                    stack.push(doubleScore);
                }

                if(ops[i] == "+"){
                    System.out.println("+ means sum the score");
                    int lastOne = stack.peek();
                    stack.pop();
//                    int secondLastOne = stack.pop();// not working since the pop will be executed. Use peek when only need the number of the certain index

                    int secondLastOne = stack.peek();
                    int sum = lastOne + secondLastOne;
                    stack.push(lastOne);
                    stack.push(sum);
                }
            }

        }

//        int sum = 0;
//        while (stack.size() > 0) sum+= stack.pop();


        int sum = stack.stream().mapToInt(i -> i).sum();

        System.out.println("The final score is " + sum);
        return sum;

    }




    public static void main(String[] args) {
//        String[] arr = {"2", "3", "C", "D", "+"};
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        calPoints(arr);

    }
}

