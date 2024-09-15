// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class MyHashSet {
    ArrayList<Integer> set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        set.add(key);
    }
    
    public void remove(int key) {
        if(set.contains(key)){
            ArrayList<Integer> set2 = new ArrayList<>();
            set2.add(key);
            set.removeAll(set2);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */