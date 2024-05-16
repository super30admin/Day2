// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Implemets hash map by using chaining to mitigate hash collision. Uses linked list to append value in case of hash collision.
// Inserts dummy node if first time key is stored in the hash map. find method is  used to get to the node in linked list.
// All the hashmap operations used find method to first go to the node or dummy node.  
class MyHashMap {
    int buckets;
    Node[] storage;
    
    // Node class
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // find node in linked list by key 
    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    // constructor
    public MyHashMap(){
        buckets = 1000;
        storage = new Node[buckets];
    }
    
    // hash function to get array index based on key
    int getBucket(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    // Add key-value to hash map 
    public void put(int key, int value) {
        int bucket = getBucket(key);

        // Ff storage at the position of bucket, Linked list is not initialised st thst position.
        // Assign a dummy node for that position
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        
        // Else append new node at the end of linked list
        Node prev = find(storage[bucket], key);
        
        // if key is already present, update data
        if(prev.next != null){
            prev.next.value = value;
        }
        // else append node
        else{
            prev.next = new Node(key, value);
        }
    }
    
    // get value of key
    public int get(int key) {
        int bucket = getBucket(key);
        
        // If linked list is not present return -1
        if(storage[bucket] == null){
            return -1;
        }
        
        Node prev = find(storage[bucket], key);
        
        // If node found for given key, return data, else return -1
        if(prev.next != null){
            return prev.next.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        
        if(storage[bucket] == null){
            return;
        }
        
        Node prev = find(storage[bucket], key);
        // If node is present remove that node
        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }
}