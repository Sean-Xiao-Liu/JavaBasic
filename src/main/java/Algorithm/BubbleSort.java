package Algorithm;

public class BubbleSort {
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int[] test = {3,4,2,1,5,4,3,9,1};
        bubbleSort(test);
        printArray(test);
    }


}
