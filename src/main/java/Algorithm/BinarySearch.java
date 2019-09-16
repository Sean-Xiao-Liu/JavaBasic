package Algorithm;

public class BinarySearch {

    private static Integer binarySearch(int[] list, int item) {// define a method, where the input are a array and an int and the output is an int
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("the mid position is " + mid);
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
//                high =  mid;// may lead to Infinite loop
            } else {
                low = mid + 1;
//                low = mid; // may lead to Infinite loop
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 6, 7 ,9,10,11};

        System.out.println(binarySearch(myList, 3)); // 1
//        System.out.println(binarySearch(myList, -1)); // null
    }
}
