package DataStructure;

public class SinglyLInkedListTest {
    public static SinglyLinkedListNode head;

    public static void append(int data){
        if(head == null){
            head = new SinglyLinkedListNode (data);
            return;
        }

        SinglyLinkedListNode current = head;
        while(current.next != null){
            current  = current.next;
        }
        current.next = new SinglyLinkedListNode (data);
    }


    public static void reverse(SinglyLinkedListNode node){

    }

    public static void main(String[] args) {
        head = new SinglyLinkedListNode(10);
        head.next = new SinglyLinkedListNode(11);
        append(12);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
