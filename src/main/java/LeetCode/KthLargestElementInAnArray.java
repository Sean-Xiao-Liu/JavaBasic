package LeetCode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class KthLargestElementInAnArray {
    /** method 1 use treeMap to store the sort numsay and use Stream to sort by reverse order  */
    public static int findKthLargest(int[] nums, int k) {

        if(k > nums.length) throw new IllegalArgumentException("wrong argument");

        Map<Integer,Integer> unsortedMap = new HashMap<>();
        Map<Integer,Integer> sortedMap = new LinkedHashMap<>();
        // put numbers into map
        for(int i = 0 ; i < nums.length ;i++){
            unsortedMap.put(i,nums[i]);
        }

        // sort the number then save it in the sorted map
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Use reverse order comparator to sort value
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        // iterate through the sorted map and find
        int count = 1;
        int result = 0;
        for(Map.Entry entry:sortedMap.entrySet()){
            if(count != k){
                count += 1;
            } else {
                result = Integer.parseInt(entry.getValue().toString());
                break;
            }
        }
        return result;
    }

    /** method 2 sort the array directly and return int on the corresponding index*/
    public static int findKthLargest2(int[] nums, int k){

        int n = nums.length;

        // bubble sort first
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (nums[j] < nums[j+1]) // when > ,it is ascending order
                {
                    // swap nums[j+1] and nums[j]
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
        return nums[k-1];
    }








    public static void main(String[] args) {
        int[] test = {1,2,3,4,4,5};
        System.out.println(findKthLargest2(test,6));

    }
}
