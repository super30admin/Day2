//Time - O(n), Space - O(n)
//Approach - chaining
class ImplementHashMap {

    private class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    Node[] storage;
    int buckets;

    public ImplementHashMap() {
        buckets = 1000;
        storage = new Node[buckets];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key != key) {
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
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            prev.next.value = value;
        } else {
            Node newNode = new Node(key, value);
            prev.next = newNode;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            return prev.next.value;
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }
}

