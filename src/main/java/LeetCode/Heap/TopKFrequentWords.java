package LeetCode.Heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static  List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();

        // save the
        for(int i = 0 ; i < words.length ; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        List<String> candidates = new ArrayList(map.keySet());

        // sort the String by custom comparator
        // first ask if value of 2 word is same
        // if same, use compareTo method, sort by alphabetical order
        // if not same, sort by reverse value order
        Collections.sort(candidates, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return candidates.subList(0, k);

    }

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words,2));

//        System.out.println("cbc".compareTo("cba"));
    }
}
