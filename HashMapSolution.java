class HashMapSolution {

    //Creating a linked list which hols key value and a pointer to next node;
    class Node {
        int key;
        int value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int buckets;
    //Creating an array of nodes;
    Node[] nodes;

    public HashMapSolution() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    //Hash function to get index in nodes array
    private int getBucket(int key) {
        return key % buckets;
    }
    
    //If the list is present we need to searh for previous link for any inserting and deletion
    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = node.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        //Checking if the index in nodes array contains any linked list or not.
        if(nodes[bucket] == null) {
            //Creating a dummy list just to make adding and removing easier.
            Node head = new Node(-1, -1);
            nodes[bucket] = head;
        }
        //Finding the previous node
        Node prev = find(nodes[bucket], key);
        //If key dose not exist
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            //If key already present just update value
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        //Checking if the index in nodes array contains any linked list or not.
        if(nodes[bucket] == null) {
            return -1;
        }
        Node prev = find(nodes[bucket], key);
        //If key dose not exist
        if(prev.next == null) {
            return -1;
        } else {
            //If key exists just return value.
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        //Checking if the index in nodes array contains any linked list or not.
        if(nodes[bucket] == null) {
            return;
        }
        Node prev = find(nodes[bucket], key);
        //If key dose not exist
        if(prev.next == null) {
            return;
        }
        //If key exists updating the pointer to the next node so current will go for garbage collector
        prev.next = prev.next.next;
    }
}