package CoreJava;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class TreeMap<i1> {
    public static void main(String[] args) {
        java.util.TreeMap<String,Integer> treeMap = new java.util.TreeMap<>(Collections.reverseOrder());

        treeMap.put("four",4);
        treeMap.put("five",5);
        treeMap.put("one",1);
        treeMap.put("two",2);
        treeMap.put("three",3);

        System.out.println(treeMap);

    }

    class ValueComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }


}

