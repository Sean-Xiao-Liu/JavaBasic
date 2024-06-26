package Algorithm.Sort;


import Utils.PrintUtil;

import java.lang.reflect.Array;

// import Utils.PrintUtil;

public class BubbleSort {

    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) // tend to swap the number and the number behind it so i < n-1
            for (int j = 0; j < n-i-1; j++) //
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    /**
     * recursive bubble sort
     * @param arr
     * @param n
     */
    public static void bubbleSort2(int[] arr,int n)
    {
        //base case
        if (n == 1)
            return;

        for(int i = 0 ; i < n-1 ; i++ ){
            if (arr[i] > arr[i+1]){
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }

        bubbleSort2(arr,n-1);
    }
    
    public static Integer[] bubbleSort5(Integer[] array){
        // set a variable to track if array is sorted
        boolean isSorted = false; 
      
        // run while loop until array is sorted
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < array.length-1 ; i++ ){
                // if array is not sorted, mark isSorted as false and swap the numbers
                if(array[i] > array[i+1]){
                    isSorted = false;
                    Integer temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }


        return array;
    }

    public static <T extends Comparable> T[] bubbleSortEverything(T[] array){ // need to make T extends Comparable to use compareTo method to
        if(array.length == 1 || array == null) return array;

        int length = array.length;
        boolean isSorted  = false;
        while (!isSorted){
            isSorted = true;
            for(int j = 0; j < length-1; j++){
                // if the array is not sorted
                if(array[j].compareTo(array[j+1]) > 0){ // can't use =, will result in dead loop
                    isSorted = false; // mark sorted is false

                    // swap array[j] and array[j+1]
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }

        }
        return array;
    }


    public static void main(String[] args) {
        Integer[] integers = new Integer[] { 3,4,2,1,18,20,5,7,-1,-7 };
        // Character[] characters = new Character[] {'d','f','t','A','z'};
        // PrintUtil.printTime();
        // PrintUtil.print(bubbleSortEverything(integers));
        // PrintUtil.printTime();
        // PrintUtil.print(bubbleSortEverything(characters));
//        System.out.println(bubbleSort5(integers));
        PrintUtil.print(bubbleSort5(integers));
    }


}
