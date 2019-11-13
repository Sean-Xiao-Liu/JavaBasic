package LeetCode;

import DataStructure.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromeLinkedList {

    /*** method 1  extract all value from the linked list ***/
    public static boolean isPalindrome(SinglyLinkedListNode head) {
        if(head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while(head.next != null){
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val); // list has all values in the linkedlist
        for(int i = 0 ; i < list.size() ; i++){
            temp.add(list.get(i));
        }
        Collections.reverse(list);
        return temp.equals(list);

    }

    /*** method 2 use stack to store the value ***/

    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(1);
        root.next = new SinglyLinkedListNode(2);
//        root.next.next = new SinglyLinkedListNode(1);
        System.out.println(isPalindrome(root));
    }
}

