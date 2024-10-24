package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) queue.offer(nums[i]);
        }
        size = queue.size();
        for (int j = 0; j < size; j++) {
            nums[j] = queue.poll();
        }
        return size;
    }

    public int removeElement2(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
