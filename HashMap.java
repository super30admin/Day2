/**
 * Using % Hashing with lnked list to store values at each node
 */

class MyHashMap {

    Node[] newHashMap;
    int n = 1000;

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        newHashMap = new Node[n];
    }
    
    public void put(int key, int value) {
        int keyHash = hash(key);
        
        if (newHashMap[keyHash] == null) {
            newHashMap[keyHash] = new Node(-1, -1); 
        }

        Node tempNode = newHashMap[keyHash];
        
        while (tempNode.next != null) {
            if (tempNode.next.key == key) {
                tempNode.next.val = value;
                return;
            }
            tempNode = tempNode.next;
        }

        tempNode.next = new Node(key, value);
    }
    
    public int get(int key) {
        int keyHash = hash(key);
        if (newHashMap[keyHash] == null || newHashMap[keyHash].next == null) {
            return -1; 
        }
        
        Node tempNode = newHashMap[keyHash].next;
        while (tempNode != null) {
            if (tempNode.key == key) {
                return tempNode.val;
            }
            tempNode = tempNode.next;
        }
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int keyHash = hash(key);
        if (newHashMap[keyHash] == null || newHashMap[keyHash].next == null) {
            return; // Nothing to remove
        }

        Node prevNode = newHashMap[keyHash];
        Node currNode = newHashMap[keyHash].next;

        while (currNode != null) {
            if (currNode.key == key) {
                // Key found, remove the node
                prevNode.next = currNode.next;
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
    }

    public int hash(int key) {
        return key % n; // Simple hash function
    }
}