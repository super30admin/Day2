// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        while (curr != null && curr.key != key) { // iterating till we find the node which has our key or till the end
                                                  // of the linked list
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    public MyHashMap() {
        buckets = 1000; // 10^3 buckets
        storage = new Node[buckets]; // creating a storage of size 1000 (10^3)
    }

    public void put(int key, int value) {
        int bucket = getBucket(key); // getting the hashcode
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1); // initialising the bucket with the dummy node
        }
        Node prev = find(storage[bucket], key);
        if (prev.next != null) {
            prev.next.value = value; // this is for updating, we stopped in the middle, the find function returned a
                                     // prev which was in the middle of the linked list
        } else {
            prev.next = new Node(key, value); // creating a new node
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return -1; // does not exist
        }
        Node prev = find(storage[bucket], key); // getting prev

        if (prev.next != null) {
            return prev.next.value; // returns the corresponding value
        }

        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return; // nothing in the linked list
        }

        Node prev = find(storage[bucket], key);

        if (prev.next != null) {
            prev.next = prev.next.next; // setting last value to null, if we want to remove the last element
                                        // prev.next.next eventually gives out as null
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