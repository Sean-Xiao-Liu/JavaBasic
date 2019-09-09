package DataStructure;

import sun.awt.image.ImageWatched;

public class LinkedListExample {

    // find length of linked list
//    LinkedListNode node = new LinkedListNode(7);

    public static int count(LinkedListNode root){// count the LinkedList length
        int count = 0 ;// ? why count start with 1
        LinkedListNode temp = root;
        while(temp != null){
            count ++;
            System.out.println(temp.val);
            temp = temp.next;
        }
        return count;
    }

    public static boolean hasLoop(LinkedListNode root){
        if (root == null) return false;

        LinkedListNode fast = root;
        LinkedListNode slow = root;

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

    public static LinkedListNode mergePoint(LinkedListNode root){
        if(!hasLoop(root)) //no loop
            return null;
        //find position of first meet point
        LinkedListNode fast=root;
        LinkedListNode slow=root;//fast and slow pointer
        do{
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
        }while(fast!=slow);

        while(root!=slow){
            root=root.next;
            slow=slow.next;
        }
        return root;
    }


    public static void main(String[] args) {
        LinkedListNode root = new LinkedListNode(2);
        root.next = new LinkedListNode(4);
        root.next.next = new LinkedListNode(6);
        root.next.next.next = root.next; // construct a linked list with loop
//        int num = count(root);
//        System.out.println(num);
        hasLoop(root);
        System.out.println("Does the linked list has loop ? The answer is " + hasLoop(root));

        mergePoint(root);
        System.out.println("The merge point is " + mergePoint(root).val);
    }


}
