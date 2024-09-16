// Time Complexity :
// put() - O(n)
// get() - O(n)
// remove() - O(n)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    int buckets;
    Node[] nodes;
    
    // hashfunction to get bucked index
    private int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }
    
    // a common method used to find previous node of the required node
    private Node find(Node head, int key) {
        Node prev = head;
        Node current = head.next;
        // iterate until the current node is not null and current key is not equal to the given key
        while(current != null && key != current.key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    // initializing buckets and nodes array
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    // add/update the given key and value
    public void put(int key, int value) {
        int index = getBucket(key);
        // if no linkedlist is present, create one by adding dummy node
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        // if given key is not present then create node with given key,value and link with previous node
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        // if given key is present then update the value
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getBucket(key);
        // if no linkedlist is present return -1
        if(nodes[index] == null) {
            return -1;
        }
        Node prev = find(nodes[index], key);
        // if given key is not present return -1
        if(prev.next == null) {
            return -1;
        }
        // return value of given key
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        // if no linkedlist is present just return to end function execution
        if(nodes[index] == null) {
            return;
        }
        Node prev = find(nodes[index], key);
        // if given key is not present return to end function execution
        if(prev.next == null) {
            return;
        }
        // remove the given key node but linking previous's next with previous's next next node
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