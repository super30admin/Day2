// Time Complexity : O(n) , Armotized Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

// This capcity changes as required.
// Run time and space is less on leetcode than using 2D boolean array.

class MyHashSet {
    class Node{
        int key;
        Node next;
        
        Node(int key){
            this.key = key;
        }
    }
    
    //returns the previous node to the given key, if key is not present then return the last node in list.
    private Node findPrev(Node node, int key){
        while(node.next!=null && node.next.key != key)
            node = node.next;
        return node;
    }

    
    int capacity; // total capcity
    double load; // load factor
    Node[] nodes; //bucket list
    int size; // actual size
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 100;
        load = 0.60;
        size = 0;
        nodes = new Node[capacity];
    }
    
    //adds element to HashSet
    public void add(int key) {
        if(size>load*capacity){ //if more than load factor then rehash.
            rehash();
            add(key);
            return;
        }
        int index = getIndex(key);
        Node node = nodes[index];
        if(node==null){ // first element at that index
            nodes[index] = new Node(Integer.MIN_VALUE);
            node = nodes[index];
        }
        node = findPrev(node, key);
        if(node.next==null){
            node.next = new Node(key);
            size++;
        }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        if(node!=null){
            node = findPrev(node, key);
            if(node.next!=null){
                node.next = node.next.next;
                size--;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        if(node!=null){
            node = findPrev(node, key);
            if(node.next!=null)
                return true;
            return false;
        }
        return false;
    }
    
    // returns index for each key
    private int getIndex(int key){
        return Math.abs(key%capacity);
    }
    
    // rehash the entire set with twice the capacity
    private void rehash(){
        capacity *= 2;
        size = 0;
        Node[] temp  = nodes;
        nodes = new Node[capacity];
        for(int i=0; i<temp.length; i++){
            if(temp[i]!=null){
                Node node = temp[i];
                while(node!=null){
                    add(node.key);
                    node = node.next;
                }
            }
        }
    }
}