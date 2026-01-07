package LeetCode.LinkedList;

public class MiddleOfTheLinkedList {
    //method 1 get count and iterate to the first
    public static ListNode middleNode(ListNode head) {
        if( head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast != null){
            fast = fast.next;
            count++;
        }

        int midpoint = count / 2;

        for(int i = 0 ; i < midpoint; i++){
            slow = slow.next;
        }

        return slow;
    }

    //method 2 fast and slew pointer at 1 pass
    public static ListNode middleNode2(ListNode head){
        if( head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null) break;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode2(head).val);
    }
}
