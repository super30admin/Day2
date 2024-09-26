// Time Complexity : best case O(1) , worst case 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Hashset using sub hash iplementation to improve performance.  
 *
 */
class MyHashSet {

	private final int bucketSize = 1999;
	private SubHashSet[] dataArr;


    /** Initialize your data structure here. */
    public MyHashSet() {
    	dataArr = new SubHashSet[bucketSize];
    }
    
    public void add(int key) {
		// if bucket is empty create new node in the bucket
		if (dataArr[key % bucketSize] == null) {
			dataArr[key % bucketSize] = new SubHashSet();
		} 
		dataArr[key % bucketSize].add(key);
    }
    
    public void remove(int key) {
    	SubHashSet subSet = dataArr[key % bucketSize];
		if (subSet != null) {
			subSet.remove(key);
		}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	SubHashSet subSet = dataArr[key % bucketSize];
		if (subSet != null) {
			return subSet.contains(key);
		}
		return false;
    }
}

class SubHashSet {

	private final int bucketSize = 47;
	private Node[] dataArr;

	class Node {
		private int key;

		private Node nextNode;

		private Node(int key) {
			this.key = key;
			this.nextNode = null;
		}
	}

    /** Initialize your data structure here. */
    public SubHashSet() {
    	dataArr = new Node[bucketSize];
    }
    
    public void add(int key) {
    	Node firstNode = dataArr[key % bucketSize];

		// if bucket is empty create new node in the bucket
		if (firstNode == null) {
			dataArr[key % bucketSize] = new Node(key);
		} else {
			// traverse all the nodes in bucket. If key found replace value
			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}

			// if key not found create a new node and add it to bucket last node
			Node newNode = new Node(key);
			previousNode.nextNode = newNode;

		}
    }
    
    public void remove(int key) {
    	Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {

			if (firstNode.key == key) {
				dataArr[key % bucketSize] = firstNode.nextNode;
				return;
			}

			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					previousNode.nextNode = firstNode.nextNode;
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}
		}
   
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {
			while (firstNode != null) {
				if (firstNode.key == key) {
					return true;
				}
				firstNode = firstNode.nextNode;
			}
		}
		return false;
    }
}
    
public class MyHashSetSubHash {
	public static void main(String[] args) {
		MyHashSet set= new MyHashSet();
		
		set.add(10);
		set.add(20);
		System.out.println(set.contains(10));
		set.remove(10);
		System.out.println(set.contains(10));
		System.out.println(set.contains(20));
		System.out.println(set.contains(25));
	}
}
