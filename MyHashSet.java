
// Time Complexity : O(1) for all operations
// Space Complexity : O(10^6) 10^6 is the total number of items


	// Your code here along with comments explaining your approach


	class MyHashSet {

	    int buckets;
	    int bucketItems;
	    boolean[][] storage;

	    /** Initialize your data structure here. */
	    public MyHashSet() {
	        buckets = 1001;
	        bucketItems = 1000;
	        storage = new boolean[buckets][];

	    }

	    private int hash1(int key) {
	        return key % buckets;
	    }

	    private int hash2(int key) {
	        return key / buckets;
	    }

	    public void add(int key) {

	        int index1 = hash1(key);
	        int index2 = hash2(key);
	        if(storage[index1] == null) {
	            storage[index1] = new boolean[bucketItems];
	        }
	        storage[index1][index2] = true;


	    }

	    public void remove(int key) {

	        int index1 = hash1(key);
	        int index2 = hash2(key);
	        if(storage[index1] == null) {
	            return;
	        }
	        storage[index1][index2] = false;


	    }

	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {

	        int index1 = hash1(key);
	        int index2 = hash2(key);
	        if(storage[index1] == null) {
	            return false;
	        }
	        return storage[index1][index2];

	    }
	}
	

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */ 


