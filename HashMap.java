class MyHashMap {


    class Node {
        int key;
        int value;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[10000];
    }

    private int findBucket(int key) {
        return key % 10000;
    }

    public void put(int key, int value) {
        Node prev;
        Node current;
        int bucketIndex = findBucket(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new Node(-1,-1);
        }
        prev = buckets[bucketIndex];
        current = prev.next;

        while (current!= null) {
            // check each node if it contains the key
            if(current.key == key) {
                // update the value if match found
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        // if value is not found
        prev.next = new Node(key, value);

    }

    public int get(int key) {
        Node prev;
        Node current;
        int bucketIndex = findBucket(key);

        // Linked list head is null
        if (buckets[bucketIndex] == null) {
            return -1;
        }

        prev = buckets[bucketIndex];
        current = prev.next;

        while (current!= null) {
            // check each node if it contains the key
            if(current.key == key) {
                // return value if match found
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        Node prev;
        Node current;
        int bucketIndex = findBucket(key);

        // Linked list head is null
        if (buckets[bucketIndex] == null) {
            return;
        }

        prev = buckets[bucketIndex];
        current = prev.next;

        while (current!= null) {
            // check each node if it contains the key
            if(current.key == key) {
                // delete the value if match found
                prev.next = current.next;
                current.next = null;
                return;
            }
            prev = current;
            current = current.next;
        }

        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */