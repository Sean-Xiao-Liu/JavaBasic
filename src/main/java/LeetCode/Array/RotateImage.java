package LeetCode.Array;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];
        for(int i = 0 ; i < matrix.length ;i++){

            int k = matrix.length-1;
            for(int j = 0 ; j < matrix[i].length ; j++){
                temp[i][j] = matrix[k][i];
                k--;
            }
        }
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                matrix[i][j] = temp[i][j] ;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        System.out.println(matrix);
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
