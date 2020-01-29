package LeetCode;

import java.util.*;

/*
* Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();*/
public class InsertDeleteGetRandom {

    ArrayList<Integer> list = new ArrayList<>();
    Set<Integer> set = new LinkedHashSet<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
//        if(list.contains(Integer.valueOf(val))) return false;
//        return list.add(val);

        if(set.contains(Integer.valueOf(val))) return false;
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
//        return list.remove(Integer.valueOf(val)); // remove integer object
        return set.remove(Integer.valueOf(val)); // remove integer object
    }


    /** Get a random element from the set. */
    public int getRandom() {
//        int size = list.size();
//        int index = random.nextInt(size);
//        return list.get(index);

        int size = set.size();
        int index = random.nextInt(size);
        return set.stream().skip(index).findFirst().get();
    }

    public static void main(String[] args) {
        // Init an empty set.
        InsertDeleteGetRandom randomSet = new InsertDeleteGetRandom();

//        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomSet.insert(1));
//
//// Returns false as 2 does not exist in the set.
//        System.out.println(randomSet.remove(2));
//
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomSet.insert(2));
//
//// getRandom should return either 1 or 2 randomly.
//        System.out.println(randomSet.getRandom());
//
//// Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomSet.remove(1));
//
//// 2 was already in the set, so return false.
//        System.out.println(randomSet.insert(2));
//
//// Since 2 is the only number in the set, getRandom always return 2.
//        System.out.println(randomSet.getRandom());

        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(4));
        for(int i = 0 ; i < 20 ; i++){
            System.out.println(randomSet.getRandom());
        }


    }
}
