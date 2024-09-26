package nov172020;

import java.util.LinkedList;

// Source Link: https://leetcode.com/problems/design-hashset/
// https://github.com/super30admin/Design-2
// Problem 4

class hashSet705 {
	private Bucket[] bucketArray;
	private int keyRange;

	/** Initialize your data structure here. */
	public hashSet705() {
		this.keyRange = 769;
		this.bucketArray = new Bucket[this.keyRange];
		for (int i = 0; i < this.keyRange; ++i)
			this.bucketArray[i] = new Bucket();
	}

	protected int _hash(int key) {
		return (key % this.keyRange);
	}

	public void add(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}

	public void remove(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucketIndex = this._hash(key);
		return this.bucketArray[bucketIndex].exists(key);
	}
}

class Bucket {
	private LinkedList<Integer> container;

	public Bucket() {
		container = new LinkedList<Integer>();
	}

	public void insert(Integer key) {
		int index = this.container.indexOf(key);
		if (index == -1) {
			this.container.addFirst(key);
		}
	}

	public void delete(Integer key) {
		this.container.remove(key);
	}

	public boolean exists(Integer key) {
		int index = this.container.indexOf(key);
		return (index != -1);
	}
}
/*
 * =============================Hash Set In Java====
 */
// - Hashset class implements Set Interface, backed by HashMap instance - This
// class permits null elements
// - The class offers constant time performance for basic operation and size assuming the hash function disappears
// - Underlying data structure for HashSet is HashMap - As it implements the set
// interface,
// - Duplicate values are not allowed
// - Objects that you insert in Hashset are not guaranteed to be inserted in
// same order, objects are inserted based on Hash Code
// - Null elements are allowed in Hash Set
// - Hash set also implements - serializable and cloneable interface
