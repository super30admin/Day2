// Time Complexity :  o(1) almost depends on size of linkedlist for that bucket
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {

    class Node { // we are using linked lists to avoid collisions, defineing our own linked lists
        int key, value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    int buckets; // we shall define bucekts and each bucket will have a linked list associated with it, each bucket will act as the head of that linked list
    Node[] nodes;
    
    public MyHashMap() {
        buckets = 10000; // reason we went for 10000 not 1000 like hashset just cuz we might had to traverse more of linkedlist since we would have had less linkedlists for better space complexity
        nodes = new Node[buckets];
    }
    
    private Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;    // we use find() to return prev node this helps us avoid lot of edge cases if we stuck to curr pointer
    }
    
    private int getHash(int key) {
        return Integer.hashCode(key) % buckets; // hashcode generates a unique value for key %  buckets to get it in range of buckets
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1); // just create dummy node which shall act as out head
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(nodes[index] == null) {
            return -1;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;   
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(nodes[index] == null) {
            return;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}