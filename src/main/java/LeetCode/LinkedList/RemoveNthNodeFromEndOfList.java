package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveNthNodeFromEndOfList {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
    // for the linked list with length L, remove the Nth node from the end equals to remove the (L-N+1)th node from the front
        ListNode length = head;
        int position = lengthOfList(length) - n + 1; // this is the position to be removed from the front

        if(position == 1) { // when first node is to be removed
            head = head.next;
            return head;
        } else { // use slow and fast pointer to remove the position node
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = head;
            ListNode slow = dummy;
            for(int i = 1; i < position ; i++){ // the fast pointer will stop at the node to be removed and the slow pointer will at the previous node
                fast = fast.next;
                slow = slow.next;
            }

            if(fast.next == null){ //when the node to be removed is the last node in the list
                slow.next = null;
            } else{
                slow.next = fast.next;
            }
        }
        return head;
    }

    // first count the length of the linked list
    public static int lengthOfList(ListNode head){
        int count = 0;
        if(head == null) return 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }



//    // this method reverse the given linked list
//    public static ListNode reverseListNode(ListNode head){
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr != null){
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev;
//    }

//    // remove the Nth node of the reversed linked list
//
//    public static ListNode removeListNode(ListNode head, int position){
//        if (head == null) {
//            return null;
//        } else if (position == 1) {
//            return head.next;
//        } else {
//            ListNode n = head;
//            for (int i = 1; i <= position ; i++) {
//                n = n.next;
//            }
//            if( n.next.next != null){
//                n.next = n.next.next;
//            } else {
//                n.next = null;
//            }
//
//            return head;
//        }
//    }

    public static ListNode removeNthFromEndTwo(ListNode head, int n){

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode current = head;
        int index = 1;
        while (current != null){
            map.put(index,current);
            index++;
            current = current.next;
        }
        int indexToBeRemoved = map.size()-n+1;
            if (indexToBeRemoved == 1) {
                return head.next;
            } else if (indexToBeRemoved+1 <= map.size()){
                map.get(indexToBeRemoved-1).next = map.get(indexToBeRemoved+1);
            } else {
                map.get(indexToBeRemoved-1).next = null;
            }
            return head;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode temp = head;
//        System.out.println("The length of the linked list is "+lengthOfList(temp));



        ListNode result =  removeNthFromEndTwo(head,2);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}





