package LeetCode;

import DataStructure.SinglyLinkedListNode;

import java.util.ArrayList;

/**
 * "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807."
 **/
public class AddTwoNumbers {
//    public static SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
//        SinglyLinkedListNode result = new SinglyLinkedListNode(0); // create a new linked list to store result
//        SinglyLinkedListNode current = result; // treat current as a pointer, it always point to the working node
//        int carryValue  = 0; // carry the value from the previous index to the next one
//        while(l1 != null || l2 != null){ //means it will keep going until both l1 and l2 become null
//            int x = (l1 != null) ? l1.val : 0; // if l1 != null, then x = l1.val or it equals to 0
//            int y = (l2 != null) ? l2.val : 0; // if l2 != null, then y = l2.val or it equals to 0
//            int sum = carryValue + x + y;
//            carryValue = sum / 10;
//            current.next = new SinglyLinkedListNode(sum % 10);//take the value of unit index, here result will update with a new node
//            current = current.next;// result keep track of all
//            if (l1 != null) l1 = l1.next; // l1 may equals to null
//            if (l2 != null) l2 = l2.next; // l2 may equals to null
//        }
//        if (carryValue > 0) {
//            current.next = new SinglyLinkedListNode(carryValue);// still have some left over, add it to linked list
//        }
//        return result.next;//
//    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(); // create an empty node as reference of head
        ListNode current = head; // current is the moving pointer
        int carryOver = 0;
        while (l1 != null || l2 != null) { // algo will keep running until the end of both linked list
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int sum = carryOver + l1Val + l2Val;
            current.next = new ListNode(sum % 10);
            current = current.next;
            carryOver = sum / 10;
            if (l1 != null) // the pointer will move only if l1 is not null to avoid nullpointer exception
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carryOver != 0) {
            current.next = new ListNode(carryOver); // need additional digit for carryOver
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
