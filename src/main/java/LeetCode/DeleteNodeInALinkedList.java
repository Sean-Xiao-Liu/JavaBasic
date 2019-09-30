package LeetCode;


import DataStructure.SinglyLinkedListNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class DeleteNodeInALinkedList {

    public static void deleteNode(SinglyLinkedListNode node) {
        node.val = node.next.val; // don't need to know the nodes before the "node"
        node.next = node.next.next; // rebuild the link by skip the node
    }

    public static void insertNode(SinglyLinkedListNode node, SinglyLinkedListNode insertNode){
        insertNode.next = node.next.next; // need to link the rest of list first before link to its previous node or it will break the list
        node.next = insertNode;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(2);
        root.next = new SinglyLinkedListNode(4);
        root.next.next = new SinglyLinkedListNode(6);
        root.next.next.next = new SinglyLinkedListNode(8);
        root.next.next.next.next = new SinglyLinkedListNode(10);

//        deleteNode(root.next.next);// delete node with value 6 from the linked list

        SinglyLinkedListNode insertNode = new SinglyLinkedListNode(20); // insert a node with value 20 between node 4 and 8

        insertNode(root.next,insertNode);

        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }

//        System.out.println(insertNode.val);
    }
}
