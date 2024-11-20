// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.ArrayList;

public class Node {

	public int value;
	public Node nextItem;
	
	public Node(int value) {
		this.value=value;
	}
}

class MyHashSet {

   public Node nodeArray[];
	int size = 5000;

	/** Initialize your data structure here. */
	public MyHashSet() {
		nodeArray = new Node[size];
	}

	public void add(int key) {
		if(!contains(key))
		if (nodeArray[key % size] == null) {
			this.nodeArray[key % size] = new Node(key);
		} else {
			Node node = this.nodeArray[key % size];

			while (node.nextItem != null) {
				node = node.nextItem;
			}

			node.nextItem = new Node(key);
		}

		int i = 0;

	}

	public void remove(int key) {
		
		if(contains(key)) {
			Node prevNode = null;	
		if (this.nodeArray[key % size] != null) {
			Node node = this.nodeArray[key % size];

			if (node.value == key && node.nextItem!=null) {
				this.nodeArray[key % size] = node.nextItem;
			}else if(node.value==key) {
				this.nodeArray[key % size] = null;
			} 
			else {
				prevNode = node;
				while (node.nextItem != null) {
					if (node.value != key) {
						prevNode = node;
						node = node.nextItem;
					} else {
						prevNode.nextItem = node.nextItem;
						break;
					}

				}
				if(node.nextItem==null && node.value==key)
					prevNode.nextItem=null;
			}

		}
	}
	}

	/** Returns true if this set contains the specified element */
	
	  public boolean contains(int key) {
	  
		  Node node=nodeArray[key%size];
		  if(node!=null) {
			 
			  if(node.value==key)
				  return true;
			  else {
				  while(node.nextItem!=null) {
					  if(node.value==key)
						  return true;
					  else
						  node=node.nextItem;
				  }
				  if(node.value==key)
					  return true;
			  }
		  }
		  return false;
	  }
}
