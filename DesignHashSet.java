package design2;

//Problem 2:(https://leetcode.com/problems/design-hashset/)
//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach

class MyHashSet {
    boolean set[];
    /** Initialize your data structure here. */
    public MyHashSet() {
        set=new boolean[1000000];	//initialize the boolean array with the given size
    }
    
    public void add(int key) {
        set[key]=true;		//sets the value of that key to true
    }
    
    public void remove(int key) {
        set[key]=false;		//sets the value of the key to false which indicates that element is removed
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];	//if the given key is present, returns true else false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class DesignHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));    // returns false (already removed) 
	}
}