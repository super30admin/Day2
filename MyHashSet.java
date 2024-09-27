// Time Complexity : O(1)
// Space Complexity : O(1000x1000) -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package Leetcode;

public class MyHashSet {
	private int key_size = 1000;
    private int item_size = 1000;
    private boolean[][] hashSet;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[key_size][];
    }
    
    private int hashKey1(int key){
        return key % key_size;
    }
    
    private int hashKey2(int key){
        return key / item_size;
    }
    
    public void add(int key) {
        int key1 = hashKey1(key);
        int key2 = hashKey2(key);
        if(hashSet[key1] == null){
            hashSet[key1] = new boolean[item_size];
        }
        hashSet[key1][key2] = true;
    }
    
    public void remove(int key) {
        int key1 = hashKey1(key);
        int key2 = hashKey2(key);
        if(hashSet[key1] != null){
            hashSet[key1][key2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int key1 = hashKey1(key);
        int key2 = hashKey2(key);
        if(hashSet[key1] != null){
            return hashSet[key1][key2];
        }
        return false;
    }

	public static void main(String[] args) {
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
