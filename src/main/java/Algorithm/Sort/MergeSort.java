package Algorithm.Sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] arrayOne,int[] arrayTwo){
        if(arrayOne == null) return arrayTwo;
        else if(arrayTwo == null) return arrayOne;

        int[] result = new int[arrayOne.length+arrayTwo.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arrayOne.length && j < arrayTwo.length){
            if(arrayOne[i] < arrayTwo[j]){
                result[k] = arrayOne[i];
                i++;
                k++;
            } else {
                result[k] = arrayTwo[j];
                j++;
                k++;
            }
        }

        // either arrayOne or arrayTwo has been fully added to the result array now
        // iterate the rest of the array

        while(i < arrayOne.length){
            result[k++] = arrayOne[i++];
        }
        while(j < arrayTwo.length){
            result[k++] = arrayTwo[j++];
        }

        return result;
    }


//    public static int[] mergeSort(int[] array){
//
//    }
//
//    public static int[] recursiveSort(int[] array,int low, int high){
//        if (high - low <= 0) return null;
//        int mid = (low+high)/2;
//        recursiveSort(array,low,mid);
//        recursiveSort(array,mid+1,high);
//        int[] temp = merge(Arrays.copyOf(array,mid-low,),array)
//        return temp;
//    }


    public static void main(String[] args) {
        int[] arrayOne = {1,2,4};
        int[] arrayTwo = {3,5,4,7,9};
        System.out.println(Arrays.toString(merge(arrayOne,arrayTwo)));
    }
}
