package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 **/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = addIntervals2(intervals,newInterval);
        Collections.sort(Arrays.asList(newIntervals),intervalComparator);

        LinkedList<int[]> merged = new LinkedList<>(); // use linkedlist here since it implements the deque interface and can invoke getLast method without traversal
        for (int[] oneOfNewIntervals : newIntervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < oneOfNewIntervals[0]) {
                merged.add(oneOfNewIntervals);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], oneOfNewIntervals[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }

    public static int[][] addIntervals(int[][] intervals, int[] newInterval){
        int[][] added = new int[intervals.length+1][];
        for(int i = 0 ; i < intervals.length ; i++){
        added[i] = intervals[i];
        }
        added[intervals.length] = newInterval;
        return added;
    }

    public static int[][] addIntervals2(int[][] intervals, int[] newInterval){
       int[][] added = Arrays.copyOf(intervals,intervals.length+1);
       added[intervals.length] = newInterval;
       return added;
    }


    public static Comparator<int[]> intervalComparator = (a,b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval ={2,5};
        InsertInterval test = new InsertInterval();
        test.insert(intervals,newInterval);
    }


}
