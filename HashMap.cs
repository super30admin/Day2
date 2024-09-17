// Time Complexity : avg O(1), worst O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MyHashMap {

    class Node{
    
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
        
    int buckets;
    Node[] nodes = null;
        
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    private Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
        
    //Hash function to get bucket position of where to put the key 
    private int getHash(int key){
        return key % buckets;
    }
    
    //caluclate hash of key to get index.
    //if node at the index is null, then initialze with dummy value (-1, -1)
    //then find the node at the index if the data with key is present
    //if found, then update the next value with key
    //if not present, then create new nodes
    public void Put(int key, int value) {
        int index = getHash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
           prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    //caluclate hash of key to get index.
    //if node at index is null, then return -1, it means key is not present 
    //else, find the node at the index 
    //if the data with key is not present, then return -1, it means key is not present 
    //else return next value
    public int Get(int key) {
        int index = getHash(key);
        if(nodes[index] == null){
            return -1;
        }
        
        Node prev = find(nodes[index], key);
        
        if(prev.next == null)
            return -1;
        
        return prev.next.value;
    }
    
    //caluclate hash of key to get index.
    //if node at index is null, then return, it means key is not present 
    //else, find the node at the index 
    //if the data with key is not present, then return, it means key is not present 
    //else update the current next value with next of next
    public void Remove(int key) {
         int index = getHash(key);
        if(nodes[index] == null){
            return;
        }
        
        Node prev = find(nodes[index], key);
        if(prev.next == null)
            return;
        
        prev.next = prev.next.next;
    }
}