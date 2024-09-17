// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
    boolean [] array;

    /** Initialize your data structure here. */
    public MyHashSet() {
        array = new boolean[1000001];       
    }
    
    public void add(int key) {
        array[key] = true;      
    }
    
    public void remove(int key) {
        array[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return array[key];        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */