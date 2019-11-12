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

    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(1);
        root.next = new SinglyLinkedListNode(2);
        root.next.next = new SinglyLinkedListNode(3);
        SinglyLinkedListNode result = reverse(root);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
