//Time Complexity: O(1) for add,remove and contains
//Space Complexity: O( 1000001 ) - given input range [0 - 1000001 ] 
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Straight forward Solution


class MyHashSet {

    boolean arr[];
    /** Initialize your data structure here. */
    public MyHashSet() {
	
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
	//set the value to true
        arr[key] = true;
    }
    
    public void remove(int key) {
	//remove the key by assigning to false
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
