package Algorithm.Sort;

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

    public static void bubbleSort3(int[] array){
        boolean sorted = false;
        int counter = 1;

        while (!sorted){
            sorted = true; // always assume sorted is true before the loop
            for (int i = 0; i < array.length - 1;i++){
                if(array[i] > array[i+1]){
                    sorted = false; // update sorted if the swap happened
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] =temp;
                }
            }

            System.out.println("This is the array after loop # "+ counter);
            printArray(array);
            counter++;
        }
        System.out.println("This is the final result");
        printArray(array);
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] test = {3,4,2,1,5,4,3,9,1,10,14,17,18,20,5,7};
        bubbleSort3(test);
    }


}
