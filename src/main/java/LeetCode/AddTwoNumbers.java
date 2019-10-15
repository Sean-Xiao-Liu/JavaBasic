package LeetCode;

import DataStructure.SinglyLinkedListNode;

import java.util.ArrayList;

public class AddTwoNumbers {
    public static SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        SinglyLinkedListNode current = result;
        int carryValue  = 0; // carry the value from the previous index to the next one
        while(l1 != null || l2 != null){ //means it will keep going until both l1 and l2 become null
            int x = (l1 != null) ? l1.val : 0; // if l1 != null, then x = l1.val or it equals to 0
            int y = (l2 != null) ? l2.val : 0; // if l2 != null, then y = l2.val or it equals to 0
            int sum = carryValue + x + y;
            carryValue = sum / 10;
            current.next = new SinglyLinkedListNode(sum % 10);//take the value of unit index, here result will update with a new node
            current = current.next;// result keep track of all
            if (l1 != null) l1 = l1.next; // l1 may equals to null
            if (l2 != null) l2 = l2.next; // l2 may equals to null
        }
        if (carryValue > 0) {
            current.next = new SinglyLinkedListNode(carryValue);// still have some left over, add it to linked list
        }
        return result.next;//
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

        SinglyLinkedListNode result = addTwoNumbers(l1,l2);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}