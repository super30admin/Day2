package design2;

import java.util.LinkedList;

//Time Complexity : O(1), Worst case O(n)
//Space Complexity : O(n) for buckets
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Coming up with the collision issue and then using
// Separate Chaining with Linked list inside Arrays. Also, using the indexOf() method.
public class DesignHashSet {
	
	int bucketSize = 15000;
    LinkedList<Integer>[] buckets;
    
    public DesignHashSet() {
        buckets = new LinkedList[bucketSize];
    }
    
    private int hashFunction(int key) {
        return key % bucketSize;
    }
    
    public void add(int key) {
        int idx = hashFunction(key);
        if(buckets[idx] == null)
            buckets[idx] = new LinkedList<>();
        if(buckets[idx].indexOf(key) == -1)
            buckets[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = hashFunction(key);
        if(buckets[idx] == null)
            return;
        if(buckets[idx].indexOf(key) != -1)
            buckets[idx].remove(buckets[idx].indexOf(key));
    }
    
    public boolean contains(int key) {
        int idx = hashFunction(key);
        if(buckets[idx] == null || buckets[idx].indexOf(key) == -1)
            return false;
        return true;
    }
}
