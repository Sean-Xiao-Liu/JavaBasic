package LeetCode;

import DataStructure.SinglyLinkedListNode;

public class MergeTwoSortedLists {
    public static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode result = new SinglyLinkedListNode(0); // common skill for linked list; work on result and output current may be faster
        SinglyLinkedListNode current = result; // when current changes, the result will also get updated
        if(l1 == null && l2 != null) {
            return l2;
        } else if( l1 != null && l2 == null){
            return l1;
        } else if( l1 == null && l2 == null){
            return null;
        }

        while(l1 != null && l2 != null){ // when they are both not null, the value of node can be compared
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 == null) ? l2:l1;
        return result.next;
    }


    public static void main(String[] args) {
        SinglyLinkedListNode l1 = new SinglyLinkedListNode(2);
        l1.next = new SinglyLinkedListNode(3);
        l1.next.next = new SinglyLinkedListNode(4);
        l1.next.next.next = new SinglyLinkedListNode(5);

        SinglyLinkedListNode l2 = new SinglyLinkedListNode(2);
        l2.next = new SinglyLinkedListNode(3);
        l2.next.next = new SinglyLinkedListNode(4);
        l2.next.next.next = new SinglyLinkedListNode(5);

        SinglyLinkedListNode result = mergeTwoLists(l1,l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
