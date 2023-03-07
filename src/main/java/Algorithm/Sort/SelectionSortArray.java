package Algorithm.Sort;

import Utils.PrintUtil;

import java.util.Arrays;

public class SelectionSortArray {
    // first, write the method to find the smallest int in the given list

    private static int findSmallest(int[] arr){
        int smallest = arr[0];
        int smallestIndex = 0;

        for (int i = 0; i < arr.length ; i++){
            if (arr[i] < smallest){
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


    // second step

    private static int[] getNewArrWithoutSmallest(int[] arr, int smallestIndex) {
        int[] newArrWithoutSmallest = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < smallestIndex) {
                newArrWithoutSmallest[i] = arr[i]; // keep the int on the left of the smallest
            } else if (i > smallestIndex) {
                newArrWithoutSmallest[i - 1] = arr[i];// pull out the smallest int, the int on the right on the smallest int would move left
            }
        }
        return newArrWithoutSmallest;
    }

    // third

    private static int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; i++) {
            int smallestIndex = findSmallest(arr);
            newArr[i] = arr[smallestIndex];

            arr = getNewArrWithoutSmallest(arr, smallestIndex);// remove the smallest int from the array and generate a new array
        }

        return newArr;
    }

    public static int[] selectionSortThree(int[] array){
        int length = array.length;
        for(int i = 0; i < length-1; i++){

            int smallestValue  = array[i];
            int smallestIndex = i;

            for(int j = i+1 ; j< length; j++){
                if (array[j] <= smallestValue) {
                    smallestValue = array[j]; // mark the new smallest number
                    smallestIndex = j; // get the index of smallest number
                }
            }

            // swap the array[i] with array[smallestIndex]
            array[smallestIndex] = array[i];
            array[i]  =smallestValue;
        }
        return array;
    }



    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10, 3, 8,9};
        PrintUtil.print(selectionSortThree(arr));

    }
}
