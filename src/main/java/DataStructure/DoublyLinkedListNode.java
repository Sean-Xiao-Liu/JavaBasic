package DataStructure;

import javax.xml.crypto.dom.DOMCryptoContext;

/*
* Doubly linked list can be traversed backwards while it takes 2 times of memory compare to singlely linked list
*
* */
public class DoublyLinkedListNode {
    public int val;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int val){
        this.val = val;
    }
}
