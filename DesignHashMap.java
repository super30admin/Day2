/*
    Leetcode problem 706: Design HashMap
    T.C: O(1) - Average T.C, Worst Case O(100) all the nodes in the node list element is not present
    S.C: O(1) - Expected to create a Hashmap of size 10^4 - Average space is constant (Worst case - O(10^6))

    Created the HashMap solution using an Array of nodes (Linked List):
    Initialized an Array of 10^4 (At most 10^4 calls will be made to put, get, and remove)
    And each index of this array will contain at most 100 nodes as 0 <= key, value <= 10^6 (i.e 10^4 * 100 = 10^6)
    The property of a Hash function is to be deterministic - i.e for every key there is only one value
    and duplicate keys do not exist.
    Hash function used to store elements is - Integer.hashCode(key) % buckets (or we can use key % buckets)
*/

class MyHashMap {

    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;            
        }
    }

    Node[] nodes;
    private int buckets;
    
    private int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = node.next;
        
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    //T.C: O(1) - average case
    public void put(int key, int value) {
        int bucket = getBucket(key);
        //Check if bucket is null - i.e Node list does not exist at index with hash property of key
        if (nodes[bucket] == null) {
            //create a dummy node
            nodes[bucket] = new Node(-1, -1);
        }
        //Find if Node with key already exists
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            prev.next = new Node(key, value);
        }
        else { //key exist
            prev.next.value = value;
        }
    }
    //T.C: O(1) - average case
    public int get(int key) {
        int bucket = getBucket(key);
        //Check if bucket is null
        if (nodes[bucket] == null) {
            return -1;
        }
        //Find if Node with key exist to return the value
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            return -1;
        }

        return prev.next.value;
    }
    //T.C: O(1) - average case
    public void remove(int key) {
        int bucket = getBucket(key);
        //Check if bucket is null
        if (nodes[bucket] == null) {
            return;
        }
        //Find if Node with key exist to return the value
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            return;
        }
        else { //Key exist - remove this node from the Node list for this nodes[bucket] item
            Node pair = prev.next;
            prev.next = prev.next.next;
            pair.next = null;
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