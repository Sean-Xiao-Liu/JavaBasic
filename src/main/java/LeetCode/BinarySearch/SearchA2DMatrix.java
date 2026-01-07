package LeetCode.BinarySearch;



public class SearchA2DMatrix {

    // method 1
//    public boolean searchMatrix(int[][] matrix, int target) {
//        boolean result = false;
//
//        for(int i = 0 ; i < matrix.length ; i++){
//            for(int j = 0 ; j < matrix[i].length ; j++){
//                if(matrix[i][j] == target){
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }

    //method 2
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int j = matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] >= target) {
                j = i;
                break;
            }
        }

        // binary search to find target
        int low = 0;
        int high = matrix[j].length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = matrix[j][mid];
            if (guess == target) {
                result = true;
            }
            if (guess > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

//    public static int findRow(int[][] matrix, int target){
//        int j = matrix.length-1;
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][matrix[i].length - 1] >= target) {
//                j = i;
//                break;
//            }
//        }
//        return j;
//    }


    public static void main(String[] args) {
        int target = 5;
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
          int[][] matrix = {{}};
//        int result = findRow(matrix,target);
//        System.out.println(result);
//        System.out.println(matrix[1][1]);
//        System.out.println(matrix.length);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(searchMatrix(matrix,target));
    }
}
