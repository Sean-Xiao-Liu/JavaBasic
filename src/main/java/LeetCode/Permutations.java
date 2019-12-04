//package LeetCode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class Permutations {
//    /*** method 1 backtracking ***/
//    public static List<List<Integer>> permute(int[] nums) {
//        int length = nums.length;
//
//        backTrack(nums,0,length);
//
//    }
//
//    public static int[] swap(int[] array, int i, int j){
//        int temp = 0;
//        temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//        return array;
//    }
//
//
//
//    public static void backTrack(int[] array,int h ,int t){
//
//        List<List<Integer>> result = new ArrayList<>();
//        if(h == t) {
//            List<Integer> list = new ArrayList<>();
//            for(int i:array){
//                list.add(i);
//            }
//            result.add(list);
//        } else {
//            for (int i = h; i <= t; i++)
//            {
//                array = swap(array,h,i);
//                backTrack(array, h+1, t);
//                array = swap(array,h,i);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int[] array = {1,2,3};
//
//    }
//}
