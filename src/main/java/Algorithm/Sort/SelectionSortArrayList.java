package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortArrayList {
    // first, write the method to find the smallest int in the given list

    private static int findSmallest(List<Integer> arr){// the input is an array list!
        int smallest = arr.get(0);// set the first int in the list as the smallest one
        int smallestIndex = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            if(arr.get(i) < smallest){
                smallest = arr.get(i);
                smallestIndex = i ;
            }
        }
        return smallestIndex;
    }

    // second, find the smallest int in the list, pull it out then save into a new list

    private static List<Integer> selectionSort(List<Integer> arr){
        List<Integer> newArr = new ArrayList<Integer>(arr.size()); // generate a new array list, which has the same length as the input array list

//        for (int i = 0 ; i < arr.size() ; i++){ // the arr.size would change as numbers removed from the list
        final int SIZE = arr.size();

        for(int i = 0; i < SIZE ; i++){

            int smallestIndex = findSmallest(arr);
            int smallest = arr.get(smallestIndex);

            newArr.add(smallest);
            arr.remove(smallestIndex);// the result within the for loop may effect the condition of the for loop
        }

        return newArr;

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(arr));
    }
}
