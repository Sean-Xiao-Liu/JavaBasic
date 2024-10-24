package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * **/
public class MeetingRooms {
    /** method 1**/
    public boolean canAttendMeetings(int[][] intervals) {

        // sort the intervals and check if they can be merged
        Collections.sort(Arrays.asList(intervals),intervalComparator);

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] <= interval[0]){
                merged.add(interval); // when intervals cannot merge save them into linked list
            } else {
                return false; // when they can be merged, means then person cannot attend both meeting, return false
            }
        }
        return true;
    }

    public Comparator<int[]> intervalComparator = (a,b) -> a[0]<b[0] ? -1:a[0] == b[0] ? 0:1;

    /** method 1.1 optimize the for loop **/
    public boolean canAttendMeetings3(int[][] intervals) {

        // sort the intervals and check if they can be merged
        Collections.sort(Arrays.asList(intervals),intervalComparator);

        for(int i = 0 ; i < intervals.length-1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }

    /** method 2 brutal force, check wither any 2 interval are overlapped**/
    public boolean canAttendMeetings2(int[][] intervals) {
        for(int i = 0 ;i < intervals.length-1 ; i++){
            for(int j = i+1 ; j < intervals.length;j++){
                if(areOverlapped(intervals[i],intervals[j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean areOverlapped(int[] a , int[] b){
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }

    public boolean canAttendMeetings4(int[][] intervals) {
        if(intervals.length == 0||intervals.length ==1) return true;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        for(int i = 0; i < intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};

        MeetingRooms test = new MeetingRooms();
        System.out.println(test.canAttendMeetings2(intervals));
    }
}
