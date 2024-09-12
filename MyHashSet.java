// Time Complexity : add , remove, contains : O(1), O(n) worst case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Node {
    int key, value;
    Node next; // chaining

    Node(int key) {
        this.key = key;
        
    }
}
class MyHashSet {
	int Max_Size = 10000;
	Node[] nodes;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new Node[Max_Size];
    }
    
    private int index(int key){
        return Integer.hashCode(key) % Max_Size;
    }
    
    private Node find(Node bucket, int key){
        Node curr = bucket, prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void add(int key) {
    	int i = index(key);    	
        if( nodes[i] == null){
            nodes[i] = new Node(-1); //indicates fake node
        }
        Node prev = find(nodes[i],key);
        if(prev.next == null){
        	//Search till the end, node not found
            prev.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null) {
        	return;
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = index(key);
        if(nodes[i] == null) {
        	return false;
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null) {
        	return false;
        }
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */