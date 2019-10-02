package DataStructure;

public class SinglyLInkedListTest {

    public static void append(SinglyLinkedListNode head,int data){
        if(head == null){
            head = new SinglyLinkedListNode (data);
            return;
        }
        SinglyLinkedListNode current = head; // traverse to the tail of the linked list
        while(current.next != null){
            current  = current.next;
        }
        current.next = new SinglyLinkedListNode (data);
    }

    // reverse method 1
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head){
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        while(curr != null){
            SinglyLinkedListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }




    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(10);
        root.next = new SinglyLinkedListNode(15);
        root.next.next = new SinglyLinkedListNode(19);
        append(root,23);

        SinglyLinkedListNode result = reverse(root);

//        System.out.println("The linkedlist append result is");
//        while(root != null){
//            System.out.println(root.val);
//            root = root.next;
//        }

        System.out.println("The linkedlist reverse result is");
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
