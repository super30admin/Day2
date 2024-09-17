package com.javadwarf.hashtable.leetcode;


public class _705_DesignHashSet {
	
	// space complexity O(n)
		// Time complexity 
		//add, remove  and contains- Worst case o(n), average case O(1)
	
	private Node[] buckets;

	class Node{
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
		}
	}
	
	public int hashValue(int key) {
		return key % buckets.length;
	}

	public _705_DesignHashSet() {
		buckets = new Node[50000];
	}

	public void add(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			buckets[index] = new Node(-1);
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			pos.next = new Node(key);
		}

	}

	public void remove(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			return;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return;
		}
		else {
			pos.next = pos.next.next;
		}

	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			return false;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return false;
		}
		else {
			return true;
		}

	}
	
	public Node findElement(int key, Node head) {

		Node curr = head;
		Node prev = null;

		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}

		return prev;

	}

}
