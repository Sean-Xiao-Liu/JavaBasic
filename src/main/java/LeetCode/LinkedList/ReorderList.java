package LeetCode.LinkedList;

import java.util.Deque;
import java.util.LinkedList;
/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        // use deque to store the nodes
        // deque is a double ended queue, so we can add and remove nodes from both ends
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null){
            deque.addLast(head);
            head = head.next;
        }
        int count = 0;
        ListNode current = new ListNode(0);
        while (!deque.isEmpty()){
            // if count is even, remove the first node from the deque and add it to the current node
            if(count % 2 == 0){
                current.next = deque.removeFirst();
                if ( count == 0) head = current.next; // if count is 0, set the head to the current node, which is the first node of updated list
            } else {
                current.next = deque.removeLast();
            }
            current = current.next;
            count++;
        }
        current.next = null; // need to set the end of current node
    }

    Node doubleNodeHead;
    Node doubleNodeTail;


    public void reorderListTwo(ListNode head) {
        ListNode current = head;
        doubleNodeHead = new Node();
        doubleNodeTail = new Node();
        doubleNodeHead.next= doubleNodeTail;
        doubleNodeTail.prev = doubleNodeHead;

        while(current != null){
            addLast(new Node(current));
            current = current.next;
        }

        ListNode newHead = new ListNode();
        ListNode newCurrent = newHead;
        doubleNodeHead = doubleNodeHead.next;
        doubleNodeTail =doubleNodeTail.prev;
        int count = 0;
        while (doubleNodeHead != doubleNodeTail){
            if (count % 2==0){
                newCurrent.next = doubleNodeHead.node;
                count++;
                doubleNodeHead = doubleNodeHead.next;
            } else {
                newCurrent.next = doubleNodeTail.node;
                count++;
                doubleNodeTail =doubleNodeTail.prev;
            }
            newCurrent = newCurrent.next;
        }
        newCurrent.next = doubleNodeHead.node;
        newCurrent.next.next = null;
        head = newHead.next;
    }

    public void addLast(Node node){
        node.next = doubleNodeTail;
        node.prev = doubleNodeTail.prev;
        doubleNodeTail.prev.next =node;
        doubleNodeTail.prev=node;
    }

    class Node{
        ListNode node;
        Node prev;
        Node next;

        // constructor without args for head and tail pointer nodes
        Node(){};

        Node(ListNode node){
            this.node = node;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

//       reorderList(root);



        ReorderList reorderList = new ReorderList();
        reorderList.reorderListTwo(root);

        while(root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
