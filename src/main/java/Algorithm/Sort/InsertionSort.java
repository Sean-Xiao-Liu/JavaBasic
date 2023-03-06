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










    public static void main(String[] args) {
        int[] test = {5,2,3,4,1,2,0};
        int[] result = insertionSort(test);
        for (int i:
             result) {
            System.out.println(i);
        }
    }
}
