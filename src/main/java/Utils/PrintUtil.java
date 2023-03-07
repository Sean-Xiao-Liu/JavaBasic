package Utils;

import java.util.Iterator;
import java.util.List;

public class PrintUtil {

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> void print(T[] array){
        for (T element: array){
            System.out.print(element + " ");
        }
    }

    public static <T> void print(List<T> list){
        Iterator iterator = list.iterator();
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static void print(String logs, Object... args){
        System.out.println(String.format(logs,args));
    }

    public static void print(String logs){
        System.out.println(logs);
    }
}
