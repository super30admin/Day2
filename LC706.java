// TC: O(sqrt(n)) for all methods since we used good hash function which equally distributes all the possible elements across all buckets
// SC: O(n) in the worst case

// where n is the total number of possible input elements

class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Node buckets[];
    private final int SIZE = 1000;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private Node find(Node ll, int key) {
        Node t1 = ll;
        while (t1 != null && t1.next != null && t1.next.key != key) {
            t1 = t1.next;
        }
        return t1;
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int bucket = getHash(key);
        if (buckets[bucket] == null) {
            buckets[bucket] = new Node(-1, -1);
        }
        Node prevNode = find(buckets[bucket], key);
        Node newNode = new Node(key, value);
        if (prevNode.next == null) {
            prevNode.next = newNode;
        } else {
            prevNode.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getHash(key);
        if (buckets[bucket] == null) {
            return -1;
        }
        Node prevNode = find(buckets[bucket], key);
        if (prevNode.next == null)
            return -1;
        return prevNode.next.value;
    }

    public void remove(int key) {
        int bucket = getHash(key);
        if (buckets[bucket] == null) {
            return;
        }
        Node prevNode = find(buckets[bucket], key);
        if (prevNode.next == null)
            return;
        prevNode.next.value = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */