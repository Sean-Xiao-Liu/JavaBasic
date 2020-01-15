package CoreJava;
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n]; //construct a matrix to reflex possible move to each position
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j ==0){
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }

            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
