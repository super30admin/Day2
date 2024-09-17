// M is pre-defined buckets, N is no. of keys added.
//Time Complexity: O(N/M).
//Space Complexity: O(M + N)
//Code run successfully on LeetCode.

class MyHashMap {
	class Node{
		int key;
		int value;
		Node next;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}	
	}
	
	Node[] nodes;
	int buckets;

    public MyHashMap() {
    	buckets = 10000;
    	nodes = new Node[buckets];
    }
    
    public int getBuckets(int key) {
    	return key%buckets;
    }
    
    public void put(int key, int value) {
    	
    	int b = getBuckets(key);
    	if(nodes[b] == null)
    	{
    		nodes[b] = new Node(-1,-1);
    	}
    	
    	Node p = find(key,nodes[b]);
    	if(p.next == null)
    		p.next = new Node(key,value);
    	
    	p.next.value = value;
        
    }
    
    public int get(int key) {
    	
    	int b = getBuckets(key);
    	if(nodes[b] == null)
    		return -1;
    	Node p = find(key,nodes[b]);
    	
    	if(p.next == null)
    		return -1;
    	
    	return p.next.value;
        
    }
    
    public void remove(int key) {
    	int b = getBuckets(key);
    	if(nodes[b] == null)
    		return;
    	Node p = find(key,nodes[b]);
    	
    	if(p.next == null)
    		return;
    	
    	else
    		p.next = p.next.next;  
    }
    
    public Node find(int key, Node head) {
    	
    	Node prev = head;
    	Node curr = prev.next;
    	
    	while(curr!= null && curr.key != key) {
    		
    		prev = curr;
    		curr = curr.next;
    	}
    	 return prev;	
    }
}