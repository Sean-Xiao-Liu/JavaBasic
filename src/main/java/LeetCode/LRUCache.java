package LeetCode;

import java.util.*;

public class LRUCache {
//    /*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//The cache is initialized with a positive capacity.*/
//
//
//
//    /** method 1 hashMAp and deque**/
//    // use deque to record the order of the key
//    // use map to store the key value pair
//    Deque<Integer> deque = new LinkedList<>();
//    Map<Integer,Integer> map = new HashMap<>();
//    int dequeCapacity;
//
//    public LRUCache(int capacity) {
//        dequeCapacity = capacity;
//    }
//
//    public int get(int key) {
//        if(deque.contains(key)){
//            deque.remove(key); // remove key from exising position
//            deque.addFirst(key); // add key to the head as it is used recently
//            return map.get(key);
//        } else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        map.put(key,value);
//
//        if (deque.contains(key)){
//            deque.remove(key); // remove key from exising position
//            deque.addFirst(key); // add key to the head as it is used recently
//        } else {
//            if(deque.size() == dequeCapacity){
//                deque.removeLast(); // remove the tail as the deque reach the capacity
//            }
//            deque.addFirst(key);
//        }
//    }
    Map<Integer,Node> cache;
    int capacity;
    Node head, tail;


    /*method 2 use custom node and map*/
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        // if cache already contains the key, update the value of node and put it to the first in the list
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value; // update the value of node
            remove(node); // remove node from exist position
            addFirst(node);
        } else { // if cache doesn't have key, need to check if capacity is reached, if so, remove the last node, which is tail.prev
            if(cache.size() == capacity){
                Node node = tail.prev; // get the node at tail
                remove(node); // remove node from linked list
                cache.remove(node.key);
            }
            Node node = new Node(key,value);
            cache.put(key,node);
            addFirst(node);
        }
    }


    // define custom double linked node
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        // constructor without args for head and tail pointer nodes
        Node(){};

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    // add node to the first after head pointer
    public void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    // remove node from the list
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1): " + cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("cache.get(2): " + cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);
        System.out.println("cache.get(1): " + cache.get(1));       // returns -1 (not found)
        System.out.println("cache.get(3): " + cache.get(3));       // returns 3
        System.out.println("cache.get(4): " + cache.get(4));       // returns 4

    }
}
