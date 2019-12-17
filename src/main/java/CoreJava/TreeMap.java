package CoreJava;

import java.util.Collections;
import java.util.Comparator;

public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<String,Integer> treeMap = new java.util.TreeMap<>(Collections.reverseOrder());

        treeMap.put("four",4);
        treeMap.put("five",5);
        treeMap.put("one",1);
        treeMap.put("two",2);
        treeMap.put("three",3);

        Comparator comp = treeMap.comparator();


        System.out.println(treeMap);

    }

}

