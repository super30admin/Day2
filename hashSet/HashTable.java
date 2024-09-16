package hashSet;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	List<Integer> bucket;

	public HashTable() {
		super();
		this.bucket = new ArrayList<Integer>();
	}

	public void insert(Integer key) {
		/*
		 * Check if the key is already present in the bucket. If not, add the key
		 */
		if (!this.bucket.contains(key)) {
			this.bucket.add(key);
		} else {
			System.out.println("The set already contains the key \'" + key + "\'.");
		}
	}

	public void delete(Integer key) {
		/*
		 * Check if the key is already present in the bucket. If it is, remove the key
		 */
		this.bucket.remove(key);
	}

	public boolean contains(Integer key) {
		/*
		 * Check if the key is already present in the bucket.
		 */
		return this.bucket.contains(key);
	}

	@Override
	public String toString() {
		if (this.bucket.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer val : this.bucket) {
			sb.append(val + " ");
		}
		sb.append("\n");
		return sb.toString();
	}

}
