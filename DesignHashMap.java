/*Algorithm:
    1. In the backend hashmap storage is a primary and secondary array's/buckets
        1.1 Primary array store the index of the data and secondary array (Array/LinkedList..) stores actual 
            Key-value
        1.2 Secondary arrays will be a linked list with a initialized dummy node for easy traversal  
    
    2. Get Primary Array Index
        1.1 Get hashcode of given key % buckets
        1.2 We are considering 10^4 as primary array size and 10^2 (100) as a secondary array size 
            This will give us balanced strorage for distributing key-values over all primary indexes
            Also, this will give us average O(1) time complexity
    3. Find place to insert/remove/get the requested value
        3.1 It can be null or last element (NULL) or you can find or doesn't exists.    
*/

class DesignHashMap
{
	private static class Node
	{
		int key, val;
		Node next;

		Node(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}
	
	Node[] nodes = new Node[10000]; // 10^4 to primary array and 10^2 to the secondary array
	
	private int getBucketIndex(int key)
	{	
		return Integer.hashCode(key) % nodes.length;
	}
	
	//Find place to insert/remove/get the element
	private Node findElement(int bucketIndex, int key)
	{
		if(nodes[bucketIndex] == null)
		{
			return nodes[bucketIndex] = new Node(-1, -1);   //Create Dummy node 
		}
        
        Node prev = nodes[bucketIndex];
		
		while(prev.next != null && prev.next.key != key)
		{
			prev = prev.next;
		}
		return prev;
	}
	
	public void put(int key, int value)
	{
		int bucketIndex = getBucketIndex(key);
		
		Node prev = findElement(bucketIndex, key);
		
		//Node doesn't exist? put new node at the end
		if (prev.next == null) 
		{
			prev.next = new Node(key, value);  
		}
		else 
		{
			prev.next.val = value;  //Update the node value
		}
	}
	
	public int get(int key)
	{
		int bucketIndex = getBucketIndex(key);
		
		Node prev = findElement(bucketIndex, key);
		
		if (prev.next == null)  //Value doesn't exists
		{
			return -1;
		}
		else 
		{
			return prev.next.val;  //Value exists
		}
	}

	public void remove(int key)
	{
		int bucketIndex = getBucketIndex(key);
		
        Node prev = findElement(bucketIndex, key);
			
		if(prev.next == null) //Value doesn't exists
        {
            return; 
        }
        
        prev.next = prev.next.next;
	}
}

/**
 * Your DesignHashMap object will be instantiated and called as such:
 * DesignHashMap obj = new DesignHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */