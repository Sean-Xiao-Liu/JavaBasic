package LeetCode.LinkedList;

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
