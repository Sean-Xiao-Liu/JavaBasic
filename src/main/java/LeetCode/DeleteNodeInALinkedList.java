package LeetCode;

import DataStructure.SinglyLinkedListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(SinglyLinkedListNode node) {

    }

    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(1);
        root.next = new SinglyLinkedListNode(2);
        root.next.next = new SinglyLinkedListNode(3);
        root.next.next.next = new SinglyLinkedListNode(4);

        if(root != null){
            System.out.println(root);
            root = root.next;
        }

    }

}
