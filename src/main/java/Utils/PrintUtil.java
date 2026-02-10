package Utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PrintUtil {

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(String message, int[] arr){
        System.out.print(message + ": ");
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
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }

    }

    public static void printTime(){
        System.out.println(
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new java.util.Date())
        );
    }

    public static void print(String logs, Object... args){
        System.out.println(String.format(logs,args));
    }

    public static void print(String logs){
        System.out.println(logs);
    }

    public static <T> void printMatrix(int[][] grid){
        for (int[] row : grid) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
