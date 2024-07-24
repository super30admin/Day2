// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    private static final int SIZE = 1000; // Size of the hash map array
    private Node[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Node[SIZE];
    }

    /** 
     * Value will always be non-negative. 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(-1, -1); // Dummy head
        }
        Node prev = findNode(map[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    /** 
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return -1;
        }
        Node prev = findNode(map[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    /** 
     * Removes the mapping of the specified value key if this map contains a mapping for the key.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return;
        }
        Node prev = findNode(map[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    /**
     * Hash function to calculate the index for a given key.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    private int hash(int key) {
        return key % SIZE;
    }

    /**
     * Helper function to find the previous node of the target key in the linked list.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private Node findNode(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
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
