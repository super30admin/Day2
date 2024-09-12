// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    List<Integer> hashSet;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(hashSet.contains(key)) {
            return;
        } else {
            hashSet.add(key);
        }
    }
    
    public void remove(int key) {
        if(!hashSet.contains(key)) return;
        hashSet.remove(hashSet.indexOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */