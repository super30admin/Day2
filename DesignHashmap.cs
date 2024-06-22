//used array of linkedlist to create hash map.
//used hash function key%10000; 
//TC: O(1)
//SC:O(N)

public class LinkedListNode {
    public int key;
    public int val;
    public LinkedListNode next;

    public LinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

public class MyHashMap {
    private LinkedListNode[] storage;
    private int capacity = 10000;
    public MyHashMap() {
        this.storage = new LinkedListNode[capacity];
    }

    private LinkedListNode find(LinkedListNode head, int key) {
        LinkedListNode prev = head;
        LinkedListNode curr = head.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void Put(int key, int value) {
        int hashfunc1 = key % capacity;
        
        if (storage[hashfunc1] == null) {
            storage[hashfunc1] = new LinkedListNode(-1, -1);  // Sentinel node
        }
        
        LinkedListNode prev = find(storage[hashfunc1], key);
        if (prev.next == null) {
            prev.next = new LinkedListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int Get(int key) {
        int hashfunc1 = key % capacity;
        if (storage[hashfunc1] == null) {
            return -1;
        }
        
        LinkedListNode prev = find(storage[hashfunc1], key);
        if (prev.next == null) {
            return -1;  // Key not found
        }
        return prev.next.val;
    }

    public void Remove(int key) {
        int hashfunc1 = key % capacity;
        if (storage[hashfunc1] == null) {
            return;  // Key not found
        }
        
        LinkedListNode prev = find(storage[hashfunc1], key);
        if (prev.next == null) {
            return;  // Key not found
        }
        prev.next = prev.next.next;
    }
}

