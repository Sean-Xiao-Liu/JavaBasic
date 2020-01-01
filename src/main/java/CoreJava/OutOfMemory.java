package CoreJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/
public class OutOfMemory {

    public static void heapSpace(){
        Integer[] array = new Integer[100000000 * 1000000000]; // java.lang.OutOfMemoryError: Java heap space
    }


    public static void garbageCollectorOverhead() {
        Map map = new HashMap<>();
        map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "randomValue");
        }
    }

    public static void permGeneration() {
        for (int i = 0; i < 1000000000; i++) {
            System.out.println(i*i);
        }
    }

    public static void main(String[] args) {
//        heapSpace();
//        garbageCollectorOverhead();
//        permGeneration();
    }

}
