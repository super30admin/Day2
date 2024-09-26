// Time Complexity : O(1) for all
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashMap {
    
    
      class Node {
            int key;
            int val;
            Node next;
          
          //private/public
          public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
        
    //this is the main hashmap
    Node[] map;
    int limit;

    /** Initialize your data structure here. */
    public MyHashMap() {
        limit = 10000;
      map = new Node[limit];
    }
    
    
    public int getHash(int key){
        return Integer.hashCode(key) % limit;
    }
    
    public Node search(Node head, int key){
        Node prev = head;
        Node curr = head;
        while(curr!= null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getHash(key);
        if(map[idx] == null){
            map[idx] = new Node(-1, -1);
            //dummy.next(new Node(key, value));
        }
        Node node = search(map[idx], key);
        
        if(node.next == null){
            node.next = new Node(key, value);
        }
        if(node.next != null){
            node.next.val = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getHash(key);
        if(map[idx] ==  null){
            return -1;
        }
        Node node = search(map[idx], key);
        if(node.next != null){
            return node.next.val;
        } 
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getHash(key);
        if(map[idx]==null){
            return;
        }
        
        Node node = search(map[idx], key);
        if(node.next == null){
            return;
        }
        
        if(node.next != null){
            node.next = node.next.next;
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */