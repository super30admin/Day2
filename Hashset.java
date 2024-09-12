/*  n - All possible values that can be added to the HashSet
    k - Size of internal Hashmap
    Time Complexity : Worst case - O(n), Avg case - O(n/k)
    Space Complexity : O(unique values in set + k)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :
    Your code here along with comments explaining your approach
    1. Used the concept of HashMap with chaining
*/

import java.util.ArrayList;
import java.util.List;
class Bucket {
    List<Integer> slots;
    
    public Bucket() {
        this.slots = new ArrayList<>();
    }
    
    public void add(Integer key) {
        boolean found = false;
        for (int i: slots) {
            if (key.equals(i)) {
                found = true;
                break;
            }
        }
        if (found == false) {
            slots.add(key);
        }
    }
    
    public void remove(Integer key) {
        slots.remove(key);
    }
    
    public boolean contains(Integer key) {
        for (int i: slots) {
            if (key.equals(i)) {
                return true;
            }
        }
        return false;
    }
}
class MyHashSet {
    int k = 2011;
    List<Bucket> map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            map.add(new Bucket());
        }
    }
    
    public void add(int key) {
        int index = getIndex(key);
        Bucket b = map.get(index);
        b.add(key);
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Bucket b = map.get(index);
        b.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        Bucket b = map.get(index);
        return b.contains(key);
    }
    
    private int getIndex(int key) {
        return (key % k);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */