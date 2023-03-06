package LeetCode;

import DataStructure.SinglyLinkedListNode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    /*** method 2 split the linked list into 2  and reverse one of them then compare ***/
    public static boolean isPalindrome2(SinglyLinkedListNode head) {
        if(head == null || head.next == null) return true;
        SinglyLinkedListNode reversedList = reverse(head);
        return compareLinkedList(reversedList,head);


    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head){ // reverse a linked list
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        while (curr != null){
            SinglyLinkedListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static boolean compareLinkedList(SinglyLinkedListNode l1, SinglyLinkedListNode l2){
        if(l1 == null || l2 == null) return false;

        while (l1 != null && l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return (l1 == null && l2 == null);
    }


    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root.next = new SinglyLinkedListNode(0);
        root.next.next = new SinglyLinkedListNode(0);


        System.out.println(isPalindrome(root));
        System.out.println(isPalindrome2(root));



    }
}

