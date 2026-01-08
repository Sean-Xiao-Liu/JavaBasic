package LeetCode.LinkedList;

public class DeleteMiddleOfLinkedList {
    /**
     * Deletes the middle node of a linked list using the two-pointer (fast/slow) approach.
     * For lists with even length, deletes the second middle node.
     * 
     * Time Complexity: O(n) - traverses the list once
     * Space Complexity: O(1) - uses constant extra space
     * 
     * @param head the head of the linked list
     * @return the head of the modified list with middle node deleted
     */
    public ListNode deleteMiddleNode(ListNode head) {
        // Handle edge case: empty list
        if(head == null ) return null;
        
        // Create a dummy node pointing to head
        // This helps us track the node BEFORE the middle node
        // so we can easily delete the middle node by changing pointers
        ListNode prev = new ListNode(0);
        prev.next = head;
        
        // Initialize two pointers:
        // - fast pointer: moves 2 steps at a time
        // - slow pointer: moves 1 step at a time, starts at dummy node
        ListNode fast = head;
        ListNode slow = prev;
        
        // Traverse the list using the two-pointer technique
        // When fast reaches the end, slow will be at the node BEFORE the middle
        // This works because fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer 2 steps
            slow = slow.next;       // Move slow pointer 1 step
        }
        
        // Delete the middle node by skipping it
        // slow is currently at the node before the middle
        // slow.next is the middle node we want to delete
        // slow.next.next is the node after the middle
        slow.next = slow.next.next;
        
        // Return the original head (the list structure is modified in-place)
        return head;
    }
}
