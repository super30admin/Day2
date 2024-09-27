package com.BigN;

public class ImplementingHashSet {

	/** Initialize your data structure here. */
	// always try to use variables and not numbers so that it is less changes
	// use square root of given size for bucket and bucketitems.
	int bucket = 1000;
	int bucketItems = 1000;
	boolean[][] storage = new boolean[bucket][];

	// First Hash Function
	private int bucket(int key) {
		return key % bucket;
	}

	// Second Hash Function
	private int bucketItems(int key) {
		return  key/bucketItems;
	}
	public void add(int key) {
		int bucket = bucket(key);
		int bucketItem = bucketItems(key);
		if (storage[bucket] == null) {
			storage[bucket] = new boolean[bucketItems];
		}
		storage[bucket][bucketItem] = true;
	}

	public void remove(int key) {
		int bucket = bucket(key);
		int bucketitem = bucketItems(key);
		// what if second array is not created?? the array out of bound will come.
		if (storage[bucket] != null) {
			storage[bucket][bucketitem] = false;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucket = bucket(key);
		int bucketItem = bucketItems(key);
		if (storage[bucket]!=null) {
			System.out.println(storage[bucket][bucketItem]);
			return storage[bucket][bucketItem];	
		}
		else
			return false;
	}

	public static void main(String args[]) {
		ImplementingHashSet implementingHashSet = new ImplementingHashSet();
		implementingHashSet.add(1);
		implementingHashSet.add(2);
		implementingHashSet.contains(1); // returns true
		implementingHashSet.contains(3); // returns false (not found)
		implementingHashSet.add(2);
		implementingHashSet.contains(2); // returns true
		implementingHashSet.remove(2);
		implementingHashSet.contains(2); // returns false (already removed)

	}
}