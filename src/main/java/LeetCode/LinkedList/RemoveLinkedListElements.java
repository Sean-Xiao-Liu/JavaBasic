package LeetCode.LinkedList;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0); // create a new list to store result
        result.next = head;

        ListNode prev = result, curr = head; // add pointer to 1st and 2nd node of result
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                prev = curr;
                curr = curr.next;
            } else{
                prev = curr;
                curr = curr.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode result = test.removeElements(head,3);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
