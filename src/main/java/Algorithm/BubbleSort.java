package Algorithm;

public class BubbleSort {
    public static void bubbleSort(int[] arr)
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

//        while(n > 1){
            bubbleSort2(arr,n-1);
//        }

    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int[] test = {3,4,2,1,5,4,3,9,1};
        bubbleSort2(test,test.length);
        printArray(test);
    }


}
