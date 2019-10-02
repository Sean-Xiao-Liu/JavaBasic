package LeetCode;

import DataStructure.SinglyLinkedListNode;

public class ReverseLinkedList {
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head){
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        while(curr != null){
            SinglyLinkedListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
