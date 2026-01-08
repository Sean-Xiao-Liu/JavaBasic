package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class MaximumTwinSumOfLinkedList {
    /**
     * Solution 1: Using HashMap to store node values by index
     * Time Complexity: O(n) - traverse list twice
     * Space Complexity: O(n) - HashMap stores all node values
     */
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode current = head;
        int index = 0;
        while (current != null) {
            map.put(index, current.val);
            current = current.next;
            index++;
        }
        int maxSum = 0;
        for (int i = 0; i < index / 2; i++) {
            maxSum = Math.max(maxSum, map.get(i) + map.get(index - i - 1));
        }
        return maxSum;
    }

    /**
     * Solution 2: Using fast/slow pointers and reversing second half
     * Time Complexity: O(n) - traverse list once to find middle, once to reverse, once to calculate
     * Space Complexity: O(1) - only uses pointer variables
     * 
     * Algorithm:
     * 1. Find the middle of the linked list using fast/slow pointers
     * 2. Reverse the second half of the list
     * 3. Traverse first half and reversed second half simultaneously
     * 4. Calculate twin sums and track maximum
     */
    public int pairSumOptimized(ListNode head) {
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast 2 steps and slow 1 step
        // When fast reaches end, slow will be at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half starting from slow
        ListNode secondHalf = reverseList(slow);
        
        // Step 3: Calculate maximum twin sum
        // Traverse first half and reversed second half simultaneously
        ListNode firstHalf = head;
        int maxSum = 0;
        
        while (secondHalf != null) {
            // Calculate current twin sum
            int twinSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, twinSum);
            
            // Move both pointers forward
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return maxSum;
    }
    
    /**
     * Helper method to reverse a linked list
     * @param head the head of the list to reverse
     * @return the new head of the reversed list
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;  // Save next node
            current.next = prev;                // Reverse the link
            prev = current;                     // Move prev forward
            current = next;                 // Move current forward
        }
        
        return prev;  // prev is now the new head
    }
}
