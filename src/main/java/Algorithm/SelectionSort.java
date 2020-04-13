package Algorithm;

public class SelectionSort {

    // iterate through the array and find the index of smallest number
    // swap it with the first number
    public static void selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) // i < n-1 since pointer j start with i+1
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selectionSort2(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1 ; i++){
            int j = i+1;
            int index = i;

            // find the index of smallest number
            for(; j< n;j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            // swap arr[i] with arr[index]
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }










    public static void main(String[] args) {
        int[] test = {5,0,1,3,2};
        selectionSort2(test);

        for(int j : test){
            System.out.println(j);
        }
    }
}
