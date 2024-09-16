class MyHashSet {
	boolean[][] storage;
	int bucketPrimary;
	int bucketSecondary;

	/** Initialize your data structure here. */
	public MyHashSet() {
		bucketPrimary = 1000;
		bucketSecondary = 1001;
		storage = new boolean[bucketPrimary][];
	}

	public int hashfunc1(int key) {
		return key % bucketPrimary;
	}

	public int hashfunc2(int key) {
		return key / bucketSecondary;
	}

	public void add(int key) {
		int bucket = hashfunc1(key);
		int bucketItem = hashfunc2(key);
		if (storage[bucket] == null) {
			storage[bucket] = new boolean[bucketItem];
		}
		storage[bucket][bucketItem] = true;
	}

	public void remove(int key) {
		int bucket = hashfunc1(key);
		int bucketItem = hashfunc2(key);
		if (storage[bucket] != null) {
			storage[bucket][bucketItem] = false;
		}

	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucket = hashfunc1(key);
		int bucketItem = hashfunc2(key);
		if (storage[bucket] != null) {
			return storage[bucket][bucketItem];
		}
		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */