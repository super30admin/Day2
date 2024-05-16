/*
 * Approch - consider an array storage and each element is a linked list inside the array
 * Time complexity - O(n)
 * Space Complexity - O(n)
 */

class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int buckets; // storage length
    Node[] storage; // array of nodes

    //Finding a node inside the indexed storage
    public Node find(Node dummy, int key){

        // initialize dummy node value to remove the first node use case
        Node prev = dummy;
        Node current = dummy.next;
        while(current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    int getBucket(int key) {
        return (Integer.hashCode(key) % buckets);
    }

    public MyHashMap() {
        buckets = 1000;
        storage = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key); // check hashcode 2%1000 = 2 or 1002%1000 =2
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1); // insert dummy node
        }
        Node prev = find(storage[bucket], key); // finding value in the linked list under index bucket storage
        if (prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            return prev.next.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) return;

        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
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