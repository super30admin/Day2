class MyHashMap {
    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }

    public class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketKey(int key) {
        return key % 1000;
    }

    public void put(int key, int value) {
        int bucket = getBucketKey(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = search(storage[bucket], key);
        if(prev.next != null) {
            prev.next.value = value;
        }
        else {
            Node newNode = new Node(key, value);
            prev.next = newNode;
        }
    }

    private Node search(Node dummy, int key){
        Node  previous = dummy;
        Node current = previous.next;
        while(current != null && current.key != key) {
            previous = current;
            current = current.next;

        }
        return previous;
    }

    public int get(int key) {
        int bucket = getBucketKey(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = search(storage[bucket], key);
        if(prev.next == null) {
             return -1;
        }else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int bucket = getBucketKey(key);
        if(storage[bucket] == null) {
            return;
        }
        Node prev = search(storage[bucket], key);
        if(prev.next == null) {
            return;
        }
        else {
            prev.next = prev.next.next;
        }

    }
}

/*
TimeComplexity for all operations is O(N) since we are using the search method.
*/

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */