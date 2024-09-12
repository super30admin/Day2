// Time Complexity :O(N) for find as it has to look through the linkedlist
// Space Complexity :O(N), less than double hashing though as you are only adding linkedlist as needed, not a whole array of size n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class MyHashSet {
    
   class Node{
       int key;
       Node next;
       
       public Node(int key){
           this.key= key;
       }
   }
    
    Node[] nodes;
    int buckets;
    
    public MyHashSet() {
        buckets = 1000;
        nodes = new Node[buckets];
   
    }
    
    private int hash1(int key){
        return key%buckets;
    }
    
    private Node find(Node head, int key){              //finds the node with key as its key, or returns null if not found
        Node previous = head;
        Node current = previous.next;
        while(current!= null && current.key!=key ){
            previous=previous.next;
            current= current.next;
        }
        return previous;
    }
    
    
    public void add(int key){
        int hash_index = hash1(key);                    //if null, adds the node to it, else, updates the value (as its just duplicate)
 
        if (nodes[hash_index]==null){
            nodes[hash_index]=new Node(-1);
            
        }
        Node prev = find(nodes[hash_index], key);
        if (prev.next == null){
            prev.next = new Node(key);
        }
        else{
            prev.next.key=key;
        }
    }
    
    public void remove(int key) {               //if null, then do nothing, else, set the previous node's next to the next of current node, so that the node is deleted
        int hash_index = hash1(key);
 
        if (nodes[hash_index]==null){
            return;
            
        }
        Node prev = find(nodes[hash_index], key);
        if (prev.next == null){
            return;
        }
        else{
            prev.next=prev.next.next;
        }
    }
    
    public boolean contains(int key) {              // returns false is its null, returns true if the key is there
        int hash_index = hash1(key);
        if (nodes[hash_index]==null){
            return false;
            
        }
        Node prev = find(nodes[hash_index], key);
        if (prev.next == null){
            return false;
        }
        else{
            return true;
        }
    }
}

