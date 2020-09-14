package LeetCode;

import DataStructure.SinglyLinkedListNode;

import java.util.HashSet;

/** the content of nodes are not duplicated so the set method works**/
public class IntersectionOfTwoLinkedLists {
    /**
     * method 1  Hash Set
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        // save all the nodes of list A to set
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        // check if any of node in list B match the set
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * method 2 two pointers
     **/
    /*
    * Maintain two pointers pApA and pBpB initialized at the head of A and B, respectively.
    * Then let them both traverse through the lists, one node at a time.
When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.);
* similarly when pBpB reaches the end of a list, redirect it the head of A.
If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11},
* which are intersected at node '9'. Since B.length (=4) < A.length (=6), pBpB would reach the end of the merged list first,
* because pBpB traverses exactly 2 nodes less than pApA does. By redirecting pBpB to head A, and pApA to head B,
* we now ask pBpB to travel exactly 2 more nodes than pApA would.
* So in the second iteration, they are guaranteed to reach the intersection node at the same time.
If two lists have intersection, then their last nodes must be the same one.
* So when pApA/pBpB reaches the end of a list, record the last element of A/B respectively.
* If the two last elements are not the same one, then the two lists have no intersections.
    * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // find out the length of 2 list
        ListNode p1 = headA, p2 = headB;
        int len1 = 0, len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }

        // move the pointer until they have the same distance to the end of tail 
        p1 = headA;
        p2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * method 3 reverse and loop
     * **/

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
//        ListNode resultA = reverse(headA);

        ListNode headB = new ListNode(5);
        headB.next = headA.next.next;

//        while(resultA != null){
//            System.out.println(resultA.val);
//            resultA = resultA.next;

        while(headB  != null){
            System.out.println(headB.val);
            headB = headB.next;
        }
    }
}
