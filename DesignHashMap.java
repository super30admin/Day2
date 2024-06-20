/*
Time Complexity :
put: O(1)
get: O(1)
remove: O(1)
Space Complexity : O(n)

Did this code successfully run on Leetcode : yes
*/ 

//make array of linkedlist

class MyHashMap {
    
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    int storageLength = 1000;

    public MyHashMap() {
        this.storage = new Node[storageLength];
    }

    int hash(int key) {
        return key % storageLength;
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
        int hashIndex = hash(key);
        if(storage[hashIndex] == null) {
            storage[hashIndex] = new Node(-1, -1);
        }
        Node prev = find(storage[hashIndex], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int hashIndex = hash(key);
        if(storage[hashIndex] == null) return -1;
        Node prev = find(storage[hashIndex], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int hashIndex = hash(key);
        if(storage[hashIndex] == null) return;
        Node prev = find(storage[hashIndex], key);
        if(prev.next != null) {
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
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
