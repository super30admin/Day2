// Time Complexity : put, get and remove operation are O(1), O(n/10000) worst case when the key is at the end of the linked list
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Revising concepts of linked list implementation
// Your code here along with comments explaining your approach

class MyHashMap {
    class Node{ //created a node for linked list
        int key; int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node [] storage; //decalred an array of linked list nodes
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    private int hash(int key){ //hash function
        return key%10000;
    }
    private Node find(Node node, int key){ //function to find a node at any given index in storage array
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    //Found out index to put key in through hashing, initialize a linked list at that index if not already present. 
    //Find out if key already exist, then we need to update the value, if key does not exist then we need to create a new node and put values at the end of the linked list
    public void put(int key, int value) { 
        int idx = hash(key);
        if (storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = find(storage[idx], key);
        if (prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
                prev.next.val = value; 
           }
        }
    
    public int get(int key) { //return value if node exists
        int idx = hash(key);
        if (storage[idx] == null) return -1;
        Node prev = find(storage[idx], key);
        if (prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) { // remove node if exists
        int idx = hash(key);
        if(storage[idx] == null) return;
        Node prev = find(storage[idx], key);
        if (prev.next == null) return;
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
