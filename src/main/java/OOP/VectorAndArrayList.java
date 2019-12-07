package OOP;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorAndArrayList {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        vector.add(1);
        arrayList.add(2);
        arrayList.add(3);
        vector.addAll(arrayList);

        Iterator iterator = vector.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
