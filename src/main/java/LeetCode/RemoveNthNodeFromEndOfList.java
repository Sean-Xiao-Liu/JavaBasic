package LeetCode;

import java.util.List;

public class RemoveNthNodeFromEndOfList {
    // reverse the list, remove the Nth node then reverse back

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = reverseListNode(head);
        ListNode temp2 = removeListNode(temp,n);
        ListNode result = reverseListNode(temp2);
        return result;
    }

    // this method reverse the given linked list
    public static ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // remove the Nth node of the reversed linked list

    public static ListNode removeListNode(ListNode head, int position){
        if (head == null) {
            return null;
        } else if (position == 1) {
            return head.next;
        } else {
            ListNode n = head;
            for (int i = 1; i <= position ; i++) {
                n = n.next;
            }
            n.next = n.next.next;
            return head;
        }
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = removeNthFromEnd(head,3);


        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        this.val = x;
    }
}



