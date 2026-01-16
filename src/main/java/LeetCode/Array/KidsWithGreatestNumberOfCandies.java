package LeetCode.Array;

import java.util.List;
import java.util.ArrayList;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = candies[0];
        for (int c:candies){
            if (c > largest) largest = c;
        }

        List<Boolean> answer = new ArrayList<>();
        for (int c:candies){
            answer.add(c+extraCandies >= largest);
        }

        return answer;
    }
}
