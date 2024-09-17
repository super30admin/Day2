// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashSet {

    private boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key]= false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key]) {
            return true;
        } else {
            return false;
        }
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */