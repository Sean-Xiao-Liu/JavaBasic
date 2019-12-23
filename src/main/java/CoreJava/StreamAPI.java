package CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(3, 2, 2, 3, 7, 3, 5,11,12);
//        System.out.println("result of external iterating " + sumIterator(list));
//        System.out.println("result of external iterating " + sumStream(list));
//        System.out.println(getSquaresList(list));
        System.out.println("sum of even number smaller than 10 is " + sumEvenNumber(10));

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

    private static int sumEvenNumber(int n){
        return IntStream
                .range(1,n+1)
                .filter(i -> i%2 == 0)
//                .map(i -> i * i)
                .sum();

    }


}
