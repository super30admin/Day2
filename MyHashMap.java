// Time Complexity :  O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Created a parent array which resembles buckets of a fixed size - 10000
// 2. Computed an index to place the key by modulo of key and fixed size
// 3. To tackle collision, create a linkedlist at the computed index. If list exists at that index and doesn't contain the key - value pair, add it. If key exists, update the corresponding value for it. If list doesn't exist at the index, create list and add key - value pair
// 4. To remove key - value pair, get the appropriate index for the bucket and remove the key - value pair from the list at that index if key exists, else no operation required
// 5. Check if key - value pair is present within the list at the computed index for the buckets, if present return the value for that key

class MyHashMap {

    class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int SIZE = 10000;
    Node[] storage;

    public MyHashMap() {
        this.storage = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        Node prev = find(storage[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null) return -1;
        Node prev = find(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prev = find(storage[index], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    private int hash(Integer key) {
        return key % SIZE;
    }

    private Node find(Node node, int key) {
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */