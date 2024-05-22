class DesignHashmap {
    //Node class to store key and value
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    int buckets;
    Node[] storage;

    //helper function to find the node
    private Node findNode(Node dummy, int key){
        Node prev = dummy;
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    //helper function to get the bucket
    int getBucket(int key){
        return key % buckets;
    }

    
    public DesignHashmap() {
        buckets = 100;
        storage = new Node[buckets];

    }
    
    //time complexity O(n) because of findNode function
    //put the key and value in the hashmap
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key, value);
        }
    }
    
    //time complexity O(n) because of findNode function
    //get the value of the key
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
            return prev.next.value;
        }
        return -1;
    }
    
    //time complexity O(n) because of findNode function
    //remove the key from the hashmap 
    public void remove(int key) {
             int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
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