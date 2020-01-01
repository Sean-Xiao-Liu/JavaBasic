package DataStructure;

import java.util.LinkedList;

public class MiddleOfLinkedList {
    public static String middleInteger(LinkedList<String> list){
        int size = list.size();
        int midPoint = size / 2;
        return list.get(midPoint);
    }

    public static void main(String[] args) {
        LinkedList<String> object = new LinkedList<String>();
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list : " + object);
        System.out.println(middleInteger(object));
    }
}
