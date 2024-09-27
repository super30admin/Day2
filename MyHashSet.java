// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : couldn't decide what data structure to be used intially

class MyHashSet {
    private HashMap<Integer, Integer> map = new HashMap();		// HashMap declaration
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {		// using the standard operation to insert key-value pair, value is 1 since we are more concerned about adding only key. Takes O(1) time.
        map.put(key, 1);
    }

    public void remove(int key) {
        map.remove(key);			// using the standard operation to remove the key from the HashMap. Takes O(1) time.
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(map.containsKey(key))	// calculates the HashCode and directly checks if the key is present or not, takes O(1) time.
            return true;
        return false;
    }
}