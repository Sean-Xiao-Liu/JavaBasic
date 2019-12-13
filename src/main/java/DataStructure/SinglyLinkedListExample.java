package DataStructure;

public class SinglyLinkedListExample {

    // find length of linked list
//    LinkedListNode node = new LinkedListNode(7);

    public static int count(SinglyLinkedListNode root){// count the LinkedList length
        int count = 0 ;// ? why count start with 1
        SinglyLinkedListNode temp = root;
        while(temp != null){
            count ++;
            System.out.println(temp.val);
            temp = temp.next;
        }
        return count;
    }

    public static boolean hasLoop(SinglyLinkedListNode root){
        if (root == null) return false;

        SinglyLinkedListNode fast = root;
        SinglyLinkedListNode slow = root;

            do{
                fast = fast.next;
                if(fast != null) fast = fast.next; // fast pointer move 2 step each time
                slow = slow.next; // slow pointer move 1 step each time
            } while (fast != null && fast!= slow);

            if(fast == null){
                return false;// if there is no loop, the fast pointer will step out the
            } else {
                return true;
            }
    }

    public static SinglyLinkedListNode mergePoint(SinglyLinkedListNode root){
        if(!hasLoop(root)) //no loop
            return null;
        //find position of first meet point
        SinglyLinkedListNode fast=root;
        SinglyLinkedListNode slow=root;//fast and slow pointer
        do{ // determine the merge point
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
        }while(fast!=slow);

        while(root!=slow){ // pop the merge point
            root=root.next;
            slow=slow.next;
        }
        return root;
    }


    public static void main(String[] args) {
        SinglyLinkedListNode root = new SinglyLinkedListNode(2);
        root.next = new SinglyLinkedListNode(4);
        root.next.next = new SinglyLinkedListNode(6);
        root.next.next.next = root.next; // construct a linked list with loop
//        int num = count(root);
//        System.out.println(num);
        hasLoop(root);
        System.out.println("Does the linked list has loop ? The answer is " + hasLoop(root));

        mergePoint(root);
        System.out.println("The merge point is " + mergePoint(root).val);
    }


}
