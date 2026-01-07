package LeetCode.LinkedList;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>(); // store the value of node as key
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result, curr = head;

        while(curr != null){
            if(map.containsKey(curr.val)){
                prev.next = curr.next;
                curr = curr.next;
            } else {
                map.put(curr.val,0);
                prev = curr;
                curr = curr.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
        ListNode result = test.deleteDuplicates(head);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}
