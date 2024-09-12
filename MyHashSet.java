
// Time Complexity :  O(1)
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

class MyHashSet {

	/** Initialize your data structure here. */
	// Declaring an array
	int set[];

	public MyHashSet() {
		// Initializing an array
		set = new int[1000001];
		Arrays.fill(set, -1); // Setting all the elements as -1
	}

	public void add(int key) {
		set[key] = key; // Setting the index of the array as the value
	}

	public void remove(int key) {
		set[key] = -1; // Removing the value, by setting the value at particular index to -1
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return set[key] != -1; // If value at particular index is not -1,
										// then it returns true, else false;
	}
}