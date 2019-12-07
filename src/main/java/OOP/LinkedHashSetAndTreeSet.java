package OOP;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedHashSetAndTreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);
//        treeSet.add(null); // Tree Set don't allow null objects

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println( "TreeSet : "+ iterator.next());
        }

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(2);
        linkedHashSet.add(4);
        linkedHashSet.add(1);
        linkedHashSet.add(3);

        Iterator iterator2 = linkedHashSet.iterator();
        while(iterator2.hasNext()){
            System.out.println("LinkedHashSet : "+iterator2.next());
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(1);
        hashSet.add(0);

        Iterator iterator3 = hashSet.iterator();
        while(iterator3.hasNext()){
            System.out.println("HashSet : " + iterator3.next());
        }


    }



}
