// Time Complexity :
// 1. For put, O(1)
// 2. For remove, O(1)
// 3. For get, O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] storage;
    
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    
    private int hash(int key) {
        return key % 10000;
    }
    
    private Node find(Node node, int key) {
        Node prev = null;
        Node curr = node;
        
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        
        Node prev = find(storage[index], key);
        
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        
        if (storage[index] == null) return -1;
        
        Node prev = find(storage[index], key);
        
        if (prev.next == null) return -1;
        
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash(key);
        
        if (storage[index] == null) return;
        
        Node prev = find(storage[index], key);
        
        if (prev.next == null) return;
        
        prev.next = prev.next.next;
    }
}

// Your code here along with comments explaining your approach
