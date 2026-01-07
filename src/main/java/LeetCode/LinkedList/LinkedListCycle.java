package LeetCode.LinkedList;


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false; // if the head is null, there is no need to check
        ListNode fast = head;
        ListNode slow = head;

        //use do while loop
        do{ // fast pointer move 2 node each time while slow pointer move 1 node each time
            fast = fast.next;
            if(fast != null) fast = fast.next;
            slow = slow.next;
        } while (fast != null && fast != slow );


        if(fast == null) {
            return false; // the fast pointer move out, means there is no loop
        } else {
            return true;
        }
    }
}

//class ListNode{
//    int value;
//    ListNode next;
//    public ListNode(int x){
//        this.value = x;
//        next = null;
//    }
//}
