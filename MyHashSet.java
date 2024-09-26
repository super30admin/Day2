//Time Complexity : O(n/k)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//got some errors while using contains, later resolved  the issue.

// how to make the solution work using one-stack only to avoid extra stack.
class Pair<K, V> {
	public K key;
	public V val;

	// constructor
	public Pair(K key, V val) {
		this.key = key;
		this.val = val;
	}
}

class Bucket {
	private List<Pair<Integer, Integer>> bucket;

	public Bucket() {
		// TODO Auto-generated constructor stub
		bucket = new LinkedList<Pair<Integer, Integer>>();

	}

	public int get(int key) {
		for (Pair<Integer, Integer> pair : bucket) {
			if (pair.key.equals(key)) {
				return pair.val;
			}
		}
		return -1;
	}

	public void put(int key, int val) {
		boolean found = false;
		for (Pair<Integer, Integer> pair : bucket) {
			if (pair.key.equals(key)) {
				pair.val = val;
				found = true;
				break;
			}
		}
		if (!found) {
			bucket.add(new Pair<Integer, Integer>(key, val));
		}

	}

	public boolean containsKey(int key) {
		boolean found = false;
		for (Pair<Integer, Integer> pair : bucket) {
			if (!pair.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(int value) {
		boolean found = false;
		for (Pair<Integer, Integer> pair : bucket) {
			if (pair.key.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public void remove(int key) {

		for (Pair<Integer, Integer> pair : bucket) {
			if (pair.key.equals(key)) {
				bucket.remove(pair);

				break;
			}
		}

	}
}

class MyHashSet {

	int k;
	List<Bucket> bucket;
	int hash;

	/** Initialize your data structure here. */
	public MyHashSet() {
		// TODO Auto-generated constructor stub
		bucket = new ArrayList<Bucket>();
		k = 100001;
		for (int i = 0; i < k; i++) {
			bucket.add(new Bucket());
		}
	}

	public void add(int key) {
		hash = key % k;

		if (!bucket.get(hash).containsKey(key)) {

			bucket.get(hash).put(key, key);
		}
	}

	public void remove(int key) {
		int hash = key % k;
		bucket.get(hash).remove(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int hash = key % k;

		// for (int i = 0; i < bucket.size(); i++) {
		if (bucket.get(hash).containsValue(key)) {
			return true;
		}
		// }

		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */