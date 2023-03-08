package Algorithm.Sort;

import Utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    private static List<Integer> quicksort(List<Integer> list) {
        if (list.size() < 2) {
            // base case, arrays with 0 or 1 element are already "sorted"
            return list;
        } else {
            // recursive case
            Integer pivot = list.get(0);

            // sub-array of all the elements less than the pivot
            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot).collect(Collectors.toList());

            // sub-array of all the elements greater than the pivot
            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot).collect(Collectors.toList());

            return Stream.of(
                    quicksort(less).stream(),
                    Stream.of(pivot),
                    quicksort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }

    private static void quickSortWithRecursiveOperation(List<Integer> integers){
        if (integers.size() > 1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> equal = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            Integer medium = integers.get( integers.size( ) / 2 ); // get the number in the medium of list
            for(Integer i : integers){
                if (i < medium){
                    smaller.add(i);
                } else if (i > medium){
                    greater.add(i);
                } else {
                    equal.add(i);
                }
            }

            quickSortWithRecursiveOperation(smaller);
            quickSortWithRecursiveOperation(equal);
            quickSortWithRecursiveOperation(greater);

            integers.clear();
            integers.addAll(smaller);
            integers.addAll(equal);
            integers.addAll(greater);
        }
    }






    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3,4,2,1,18,20,5,7,-1,-7));
        PrintUtil.printTime();
        quickSortWithRecursiveOperation(list);
        PrintUtil.printTime();
        PrintUtil.print(list);
    }
}
