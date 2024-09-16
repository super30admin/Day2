// Time Complexity : O(1) - Considering, we are only traversing 100 nodes that is constant
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {

    //Node class for LinkedList
    class Node{
        //pair of key and value;
        int key, val;
        //next node
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //Primary array of nodes
    private Node[] nodes;
    //Number of buckets in primary array
    private int buckets;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private int getBucket(int key){
        //first hashing function
        return Integer.hashCode(key) % buckets;
    }

    //function to traverse and find a key in linked list.
    //getting, head or dummy node of linkedList and key
    private Node find(Node prev, int key) {
        //curr node to start traversing to find key. to ignore the dummy node.
        Node curr = prev.next;

        //until curr is null and we find key, assign curr to prev and curr.next to curr.
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int val) {
        //to get bucket using hash function;
        int bucket = getBucket(key);

        //if no linkedList present, create dummy node and assign as first node.
        if(nodes[bucket] == null) {
            nodes[bucket] = new Node(-1, -1);
        }
        //find the node in given linkedList by using key.
        Node prev = find(nodes[bucket], key);

        //key not found, create new node at end with ket and val.
        if(prev.next == null) {
            prev.next = new Node(key, val);
        } //key found, change the value of curr node.
        else {
            prev.next.val = val;
        }
    }

    public int get(int key) {
        //get bucket using hash function
        int bucket = getBucket(key);
        //if no linkedList at bucket, no key present, return -1.
        if(nodes[bucket] == null) {
            return -1;
        }
        //find node using key.
        Node prev = find(nodes[bucket], key);
        //if key not found, return -1
        if(prev.next == null){
            return -1;
        }//if key found, return value at key node. i.e. curr node.
        else{
            return prev.next.val;
        }
    }

    public void remove(int key) {
        //get bucket using hash function
        int bucket = getBucket(key);
        //if no linkedList at bucket, no key present, return
        if(nodes[bucket] == null) {
            return;
        }
        //find node using key.
        Node prev = find(nodes[bucket], key);
        //if key not found, return
        if(prev.next == null) {
            return;
        } //if key found, remove node assigning, prev.next = curr.next and assign curr.next to null for garbage collection.
        else {
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
        }
    }
}