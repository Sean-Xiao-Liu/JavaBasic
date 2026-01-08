package LeetCode.LinkedList;

/***
 * 
 * Time Complexity: O(n)
The algorithm traverses the linked list once:
The while loop continues as long as even != null && even.next != null
In each iteration, both odd and even pointers advance by one node
Every node in the list is visited exactly once
Where n is the number of nodes in the linked list

Space Complexity: O(1)
The algorithm uses constant extra space:
Only three pointer variables are used: odd, even, and evenHead
No additional data structures are created
The rearrangement is done in-place by modifying the next pointers of existing nodes
The space used doesn't scale with the input size

Summary:
Time: O(n) - single pass through the list
Space: O(1) - constant space, in-place modification
 */


public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // boundary cases
        if(head == null ) return null;
        if(head.next == null) return head;


        ListNode odd = head; // mark the odd part
        ListNode even = head.next;
        ListNode evenHead = even; // mark the head of even part
        while (even != null && even.next != null) { // can't use
            odd.next = even.next; // eg. 1 -> 3
            odd = odd.next; // move the odd pointer
            even.next = odd.next; // eg. 2 -> 4
            even = even.next; // move the even pointer
        }

        odd.next = evenHead; // concat the odd part with the even part
        return head;
    }
}
