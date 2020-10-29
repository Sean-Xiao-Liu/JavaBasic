package LeetCode;

import DataStructure.SinglyLinkedListNode;

public class ReverseLinkedList {

    /** method 1 iterative method */
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /** method 2 recursive method */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // boundary case
        ListNode temp = reverseList(head.next); // mark the node to be returned，先一直走到最后一个node，再倒回来执行下一行

        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
//        ListNode result = reverse(root);
        ListNode result = reverseList(root);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
