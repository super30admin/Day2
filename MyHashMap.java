// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = bucket(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            // key is not present in the linkedlist
            prev.next = new Node(key, value);
        }
        else {
            // key already present in the linkedlist
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int bucket = bucket(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */