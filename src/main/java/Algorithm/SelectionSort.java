package Algorithm;

public class SelectionSort {
    public static void selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
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
            int index = i;
            for(int j = i+1; j< n;j++){
                if(arr[j] < arr[index]){
                    index = j;
                }

                // swap arr[i] and arr[index], make sure arr[i] is always the smallest one
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }










    public static void main(String[] args) {
        int[] test = {3,4,2,1,5,4,3,9,1};
        selectionSort2(test);

        for(int j : test){
            System.out.println(j);
        }
    }
}
