// Time Complexity : 
    // put: O(N/K) where K is the size of max node length within the array of nodes
    // get: O(N/K) where K is the size of max node length within the array of nodes
    // remove: O(N/K) where K is the size of max node length within the array of nodes
// Space Complexity : O(N) space complexity where N is the number of elements 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I have a difficult time with Nodes and pointers, had to follow along for some parts witht the class video


// Your code here along with comments explaining your approach
// Approach is to use an array of nodes where each node points to that subset of hash function. 
// For each key we calculate has function, create node if node doesn't exist, if it iexists we check the nodes in sequence to add or remove elements


class MyHashMap {
    int buckets;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;

        }
    }

    private int getHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
             prev = curr;
             curr = curr.next;
        }

        return prev;

    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    } 
    
    public void put(int key, int value) {
        int mod = getHash(key);
        if(storage[mod] == null){
            storage[mod] = new Node(-1, -1);
        }

        Node prev = getPrev(storage[mod], key);
        if (prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value; //simply updating node, value already exists
        }
    }
    
    public int get(int key) {
        int mod = getHash(key);
        if(storage[mod] == null){
            return -1;
        }
        
        Node prev = getPrev(storage[mod], key);
        if (prev.next == null){ //node isn't present
            return -1;
        }
        else{
            return prev.next.value; 
        }
        
    }
    
    public void remove(int key) {
        int mod = getHash(key);
        if (storage[mod] == null){
            return;
        }
        else{
            Node prev = getPrev(storage[mod], key);
            if (prev.next == null){
                return;
            }
            else{
                Node cur = prev.next;
                prev.next = cur.next;
                cur.next = null; 
            }
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
