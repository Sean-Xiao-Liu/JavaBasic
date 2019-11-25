//package LeetCode;
//
//
//
//import java.util.*;
//
//public class ThreeSum {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        // need to hashMap, one to check duplicates list and  another one to find the numbers
//
//        //first sort the array to reduce the number of total research
//        Arrays.sort(nums);
//
//        //second create a map to store the first number
//        Map<Integer,Integer> firstNumber = new HashMap<>();
//        Map<Integer,Integer> twoSum = new HashMap<>();
//
//        //Then create the Lists to store possible answers
//        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> answer = new ArrayList<>();
//
//        int target = 0;
//        for(int i = 0 ; i < nums.length; i++){
//            if(firstNumber.containsValue(nums[i])) {
//                break;
//            } else {
//                firstNumber.put(i,nums[i]);
//                target = 0 - nums[i]; // target should be sum of other 2 numbers
//            }
//            for(int j = i+1 ; j < nums.length ; j++){
//                int temp = target - nums[j];
//                if(twoSum.containsKey(temp)) {
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(twoSum.get(temp));
//                    answer.add(list);
//                }
//                twoSum.put(nums[j],nums[j]);
//            }
//
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        List<List<Integer>> result = threeSum(nums);
//        System.out.println(result.toString());
//
//    }
//
//}
