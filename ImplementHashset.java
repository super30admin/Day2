// Time Complexity : O(1) on average but in the worst case it could be O(n) for add, remove contains;
// Space Complexity : O(n) depending on the number of entries in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Customized the linked list + array approach from yesterday's class


// Your code here along with comments explaining your approach

class MyHashSet {
    
    private class Node{
        int value;
        Node next;
        
        Node(int value){
            this.value = value;
        }
    }
    
    Node[] nodes;
    
    private int findIndex(int value){
        return Integer.hashCode(value) % nodes.length;
    }
    
    private Node findElement(int index, int value){
        if(nodes[index] == null){
            return nodes[index] = new Node(-1);
        }
        else{
            Node prev = nodes[index];
            while(prev.next != null && prev.next.value != value){
                prev = prev.next;
            }
            return prev;
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new Node[1000001];
    }
    
    public void add(int key) {
        int index = findIndex(key);
        Node prev = findElement(index, key);
        
        if(prev.next != null){
            prev.next.value = key;
        }
        else{
            prev.next = new Node(key);
        }        
    }
    
    public void remove(int key) {
        int index = findIndex(key);
        Node prev = findElement(index, key);
        
        if(prev.next != null){
            prev.next = prev.next.next;
        } 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = findIndex(key);
        Node prev = findElement(index, key);
        
        if(prev.next != null && prev.next.value == key){
            return true;
        } 
        else{
            return false;
        }
    }
}