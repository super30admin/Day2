// Time Complexity : O(n) for put, get, remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }
    
    Node[] nodes;
    int buckets;

    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }
    
    private int getBucket(int key){
        return key % buckets;
    }
    
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index] == null){
            //Initialise linked list with a dummy node
            Node newNode = new Node(-1, -1);
            nodes[index] = newNode;
        }
        // Update the value if Node exists or create a new Node
        Node prev = findNode(nodes[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);;
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){
            return -1;
        }
        // Traverse the linkedlist to find the value
        Node prev = findNode(nodes[index], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;     
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){
            return;
        }
        // Traverse the linkedlist to remove it
        Node prev = findNode(nodes[index], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
    
    private Node findNode(Node head, int key){
        Node previous = head;
        Node current = head.next;
        while(current != null && key != current.key){
                previous = current;
                current = current.next;
        }
        return previous;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */