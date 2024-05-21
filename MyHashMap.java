class MyHashMap {
    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int buckets;
    Node[] storage;

    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }        
        return prev;
    }

    int getBucket(int key) {
        return Integer.hashCode(key) % buckets; // returns a value of the hash key which is given
    }

    public MyHashMap() {
        buckets = 1000;
        storage = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            return prev.next.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        } 
    }
}