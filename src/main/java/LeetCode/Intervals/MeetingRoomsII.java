package LeetCode.Intervals;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // Sort intervals based on the starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[intervals[intervals.length - 1][1]];

        for (int[] ints : intervals) {
            for (int i = ints[0]; i < ints[1]; i++) {
                dp[i]++;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public int minMeetingRooms2(int[][] intervals) {
        // Sort intervals based on the starting value
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int endTimePointer = 0;
        int room = 0;

        for (int i = 0; i < intervals.length ;i++){
            if (startTime[i] < endTime[endTimePointer]) {
                room++;
            } else {
                endTimePointer++;
            }
        }
        return room;
    }
}
