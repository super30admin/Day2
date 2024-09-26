// Time Complexity : best case O(1) , worst case 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Define a Node to maintain a linked list in each bucket .
 * 2. Define bucketsize as a prime number to reduce the hash collision. We may need to increase or decrease based on performance.
 * 3. add:Check bucket first element. if it is null add new node to bucket. Otherwise find if exist, if not exist add it as last node in the linked list.
 * 4. contain:Check bucket first element. if it is null return false.Otherwise find and return true if exist, if not exist return false.
 * 5. remove:Check bucket first element. if it is null return.Otherwise find and remove node and adjust the previous node next node.   
 *
 */
class MyHashSet {

	private final int bucketSize = 1999;
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
    public MyHashSet() {
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
    
public class MyHashSetMain {
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
