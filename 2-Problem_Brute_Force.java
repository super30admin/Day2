// 705. Design HashSet - https://leetcode.com/problems/design-hashset/
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. This array only stores true and false.

// HashSet contains only unique values unlike HashMap that stores duplicates

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] arr;
    
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    } 
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */