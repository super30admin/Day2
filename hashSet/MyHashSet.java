// Time Complexity : O(n/k), k->bucket size = 4987
// Space Complexity : O(k+u), u-> unique values in hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Used an approach similar to designing a hashmap


package hashSet;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
	List<HashTable> hashTable;
	int hashKey;

	public MyHashSet() {
		// HashFunction = key % 4987 (4987 is a prime number)
		super();
		this.hashKey = 4987;
		this.hashTable = new ArrayList<HashTable>();
		for (int i = 0; i < hashKey; i++) {
			hashTable.add(new HashTable());
		}
	}

	public void add(int key) {
		// Get the hashcode of the key, and put data into that specific bucket.
		this.hashTable.get(key % hashKey).insert(key);
	}

	public void remove(int key) {
		// Get the hashcode of the key, and remove data from that specific bucket.
		this.hashTable.get(key % hashKey).delete(key);
	}

	public boolean contains(int key) {
		// Get the hashcode of the key, and search for data in that specific bucket.
		return this.hashTable.get(key % hashKey).contains(key);
	}

	public void printSet() {
		for (HashTable entry : this.hashTable) {
			if (entry.toString() != null) {
				System.out.println(entry.toString());
			}
		}
	}

	public static void main(String[] args) {
		MyHashSet obj = new MyHashSet();
		obj.add(1);
		obj.add(2);
		obj.add(2000);
		obj.add(5000);
		obj.add(5000);
		obj.add(5);
		System.out.println("obj.get(3)=" + obj.contains(3));
		System.out.println("obj.get(1)=" + obj.contains(1));
		System.out.println("obj.get(2000)=" + obj.contains(2000));
		System.out.println("obj.get(5000)=" + obj.contains(5000));
		System.out.println("Removing obj(2)..");
		obj.remove(2);
		obj.printSet();
	}
}
