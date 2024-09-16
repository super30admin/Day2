// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[] a = new boolean[1000001];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        a[key] = true;    
    }
    
    public void remove(int key) {
        a[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       return a[key]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */