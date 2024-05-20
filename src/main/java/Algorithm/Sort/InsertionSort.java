package Algorithm.Sort;

import Utils.PrintUtil;

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

    public static int[] insertionSort3(int[] arr){
        if(arr == null || arr.length==1) return arr;
        int n = arr.length;

        for(int i = 1; i < n ; i++){ // start and 1 because assume the first number is in the right place
            int numberTobeMoved = arr[i];
            int j = i-1; // only need to move the numbers before index i

            while(j>=0 && arr[j]>numberTobeMoved){
                arr[j+1]=arr[j]; // the previous arr[j] is in arr[j+1] now
                j=j-1;
                PrintUtil.print(arr);
            }
            // if arr[j] < numberToBeMoved, then numberToBeMoved should ge behind it
            arr[j+1]=numberTobeMoved;
        }
        return arr;
    }




    public static void main(String[] args) {
        int[] test = {5,2,3,4,1,2,0,-1,78,-16,124};
////        int[] result = insertionSortThree(test);
//        for (int i:
//             result) {
//            System.out.println(i);
//        }
        PrintUtil.print(insertionSort3(test));
    }
}
