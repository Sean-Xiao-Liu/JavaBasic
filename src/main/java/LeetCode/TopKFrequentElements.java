package LeetCode;

import java.util.*;

/*Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]*/
public class TopKFrequentElements {
    /** method 1 use tree map with descending comparator**/
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> unsortedMap = new HashMap<>();
        Map<Integer,Integer> sortedMap = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();

        // save integer and they appearance in unsorted map
        for(int i = 0 ; i < nums.length ; i++){
            unsortedMap.put(nums[i],unsortedMap.getOrDefault(nums[i],0 )+1);
        }

        // sort thr pairs by value and store in linkedHashMap
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Use reverse order comparator to sort value
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        // add top k into the list
        for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()){
            if(k != 0){
                list.add(entry.getKey());
                k--;
            }
            if(k == 0){ // once k reach 0, there is no need to continue the loop
                break;
            }
        }
        return list;
    }

    /** method 2 use priority queue **/
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> unsortedMap = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> unsortedMap.get(n1) - unsortedMap.get(n2)); // introduce comparator into the heap, int with smaller appearance will be put in the front of the queue and be polled first
        List<Integer> list = new ArrayList<>();

        // save integer and they appearance in unsorted map
        for(int i = 0 ; i < nums.length ; i++){
            unsortedMap.put(nums[i],unsortedMap.getOrDefault(nums[i],0 )+1);
        }

        // only keep k elements in queue
        for (int n: unsortedMap.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll(); // poll from the front of the queue
        }

        while(!heap.isEmpty()){
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }




    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,4,4,5};
        System.out.println(topKFrequent2(nums,2));
    }
}
