package LeetCode;

import java.util.*;

public class LRUCache {
    /*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.*/



    /** method 1 hashMAp and deque**/
    // use deque to record the order of the key
    // use map to store the key value pair
    Deque<Integer> deque = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();
    int dequeCapacity;

    public LRUCache(int capacity) {
        dequeCapacity = capacity;
    }

    public int get(int key) {
        // if contains key in deque poll the front and offer the most recent use in the end
        if(deque.contains(key)){
            if(deque.size() == dequeCapacity){
                if(deque.contains(key)){ // if the last is same as the key, don't change
                    deque.remove(key);
                    deque.offer(key);
                }
            }
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key,value);
        if(deque.size() == dequeCapacity){
            if(key != deque.peekLast()){ // if the last is same as the key, don't change
                deque.poll();
                deque.offer(key);
            }
        } else if(deque.size() < dequeCapacity){
            deque.offer(key);
        }
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println("cache.get(1): " + cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println("cache.get(2): " + cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);
//        System.out.println("cache.get(1): " + cache.get(1));       // returns -1 (not found)
//        System.out.println("cache.get(3): " + cache.get(3));       // returns 3
//        System.out.println("cache.get(4): " + cache.get(4));       // returns 4

//        System.out.println("cache.get(2): " + cache.get(2));       // returns -1
//        cache.put(2, 6);
//        System.out.println("cache.get(1): " + cache.get(1));       // returns -1
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println("cache.get(1): " + cache.get(1));       // returns 2
//        System.out.println("cache.get(2): " + cache.get(2));       // returns 6

        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println("cache.get(4): " + cache.get(4));       // returns 4
        System.out.println("cache.get(3): " + cache.get(3));       // returns 2
        System.out.println("cache.get(2): " + cache.get(2));       // returns 2
        System.out.println("cache.get(1): " + cache.get(1));       // returns -1

    }
}
