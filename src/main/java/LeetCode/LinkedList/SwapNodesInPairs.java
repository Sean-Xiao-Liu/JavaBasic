package LeetCode.LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 * */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

//        ListNode temp = head.next;
//        if(head.next.next != null){
//
//            head.next = head.next.next;
//            temp.next = head;
//            swapPairs(head.next.next);
//        }
//
//        return temp;

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped，标记两个node
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping, recursive call, swap the tail first
        firstNode.next  = swapPairs(secondNode.next); // 原来的第一个Node后面接的是swap完的第三个
        secondNode.next = firstNode;

        // swap之后原来的第二个node变成了head，则输出新的head
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode result = test.swapPairs(head);

    }
}
