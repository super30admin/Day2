//Time Complexity: O(1) Worst case: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node [] nodes;
    int buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }  
    private int index(int key) {
         return Integer.hashCode(key) % buckets;
        // return (key) % buckets;
    }
    private Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key != key ) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    } 
        
    
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       int index = index(key);
       if(nodes[index] == null) { // if no linked list at that place 
           nodes[index] = new Node(-1,-1);
       }
        Node prev = find(nodes[index], key);
        
        if(prev.next == null) { //no find
            prev.next = new Node(key, value);
        }
        else {
            prev.next.val = value; 
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key); 
        if(nodes[index] == null) 
            return -1;
        Node prev = find(nodes[index], key);
        if(prev.next == null) { //no find
            return -1;
        }
        return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key); 
        if(nodes[index] == null) 
            return;
         Node prev = find(nodes[index], key);
        if(prev.next == null) { //no find
            return ;   
        }
         prev.next = prev.next.next;
    }
  }


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */