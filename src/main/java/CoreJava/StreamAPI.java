package CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("result of external iterating " + sumIterator(list));
        System.out.println("result of external iterating " + sumStream(list));
        System.out.println(getSquaresList(list));

    }

    private static int sumIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    private static int sumStream(List<Integer> list) {
        return list.stream()
                .filter(i -> i > 10)
                .mapToInt(i -> i)
                .sum();
    }

    private static List<Integer> getSquaresList(List<Integer> list){
        //get list of unique squares
        List<Integer> squaresList = list.stream()
                .map( i -> i*i)
                .distinct() // only keep distinct result
                .collect(Collectors.toList());
        return squaresList;
    }




}
