package Day_2;

//Time Complexity : Insertion O(1), Removal - O(1), Contains O(1)
//Space Complexity : O(m+n), m = number of buckets and n = number of bucketItems 
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have implemented HashSet using double hashing.
*/

public class MyHashSetUsingDoubleHashing {
	boolean[][] storage;
	int buckets;
	int bucketItems;

	public MyHashSetUsingDoubleHashing() {
		buckets = 1000;
		bucketItems = 1000;
		storage = new boolean[buckets][];
	}

	public int bucket(int value) {
		return value % buckets;
	}

	public int bucketItem(int value) {
		return value / buckets;
	}

	public void add(int value) {
		int bucket = bucket(value);
		int bucketItem = bucketItem(value);
		if (storage[bucket] == null) {
			storage[bucket] = new boolean[bucketItems];
		}
		storage[bucket][bucketItem] = true;
	}

	public void remove(int value) {
		int bucket = bucket(value);
		int bucketItem = bucketItem(value);
		if (storage[bucket] != null) {
			storage[bucket][bucketItem] = false;
		}
	}

	public boolean contains(int value) {
		int bucket = bucket(value);
		int bucketItem = bucketItem(value);
		return storage[bucket] != null && storage[bucket][bucketItem];
	}

	public static void main(String[] args) {
		MyHashSetUsingDoubleHashing obj = new MyHashSetUsingDoubleHashing();
		obj.add(2);
		System.out.println(obj.contains(2));
		obj.remove(2);
		boolean param_3 = obj.contains(2);
		System.out.println(param_3);
	}
}