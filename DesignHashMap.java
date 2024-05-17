class DesignHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    int buckets;
    Node[] storage;

    public DesignHashMap() {
        buckets = 1000;
        storage = new Node[buckets];
    }

    public int getBucket(int key){
        return Integer.hashCode(key) % buckets;
    }

    private Node search(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = search(storage[bucket],key);
        if(prev.next != null){
            prev.next.value = value;

        }
        else{
            prev.next = new Node(key,value);

        }
        
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return -1;      
        }
        Node prev = search(storage[bucket],key);
        if(prev.next != null){
        return prev.next.value;
        }
        return -1;
    }

    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;      
        }
        Node prev = search(storage[bucket],key);
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