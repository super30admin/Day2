// Time Complexity : Amortized O(1) for every method (add, remove, contains)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Node {
    int key;
    Node next;
    
    Node(int key) {
        this.key = key;
    }
}

class HashSet {

    Node[] storage;
    int buckets;
    
    public HashSet() {
        buckets = 10000;       
        storage = new Node[buckets]; 
    }
    
    public int getHash(int key) {
        return key % 10000;
    }
    
    public Node find(int key, Node head) {
        Node prev = head, current = head.next;
        
        while(current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }
    
    public void add(int key) {
        int bucket = getHash(key);
        
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1);
        }
        
        Node prev = find(key, storage[bucket]);
        
        if(prev.next == null) {
            prev.next = new Node(key);
        } else {
            prev.next.key = key;
        }
    }
    
    public void remove(int key) {
        int bucket = getHash(key);
        
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1);
        }
        
        Node prev = find(key, storage[bucket]);
        
        if(prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    public boolean contains(int key) {
        int bucket = getHash(key);
        
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1);
        }
        
        Node prev = find(key, storage[bucket]);
        
        if(prev.next == null) {
            return false;
        } else {
           return key == prev.next.key;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * HashSet obj = new HashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */