package Algorithm.Sort;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) { // no i in this block, only j
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }



    public static void insertionSort2(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n ; i++){
            int key = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j=j-1;

            }
            arr[j+1] = key;
        }
    }

    public static int[] insertionSortThree(int[] array){
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
        int[] test = {5,2,3,4,1,2,0,-1,78,-16,124};
        int[] result = insertionSortThree(test);
        for (int i:
             result) {
            System.out.println(i);
        }
    }
}
