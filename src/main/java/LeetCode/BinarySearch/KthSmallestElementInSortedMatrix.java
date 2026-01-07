package LeetCode.BinarySearch;

import java.util.*;

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.*/
public class KthSmallestElementInSortedMatrix {

    /** method 1 use set to record -> not working since duplicate also count**/
    public static int kthSmallest(int[][] matrix, int k) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        //for loop the whole matrix
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                set.add(matrix[i][j]);
                if(set.size() == k){
                    result = matrix[i][j];
                    break;
                }
            }
        }
        return result;
    }

    /** method 2 use array list/array to store then sort **/
    public static int kthSmallest2(int[][] matrix, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n2-n1);
        List<Integer> list = new ArrayList<>();
        //for loop the whole matrix
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int[][] matrix2 = {{1,2},{3,3}};
        System.out.println(kthSmallest2(matrix2,1));
    }
}
