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

    public static void main(String[] args) {
        LinkedListNode root = new LinkedListNode(2);
        root.next = new LinkedListNode(4);
        root.next.next = new LinkedListNode(6);
        int num = count(root);
        System.out.println(num);
    }


}
