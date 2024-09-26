package s30.precourse.Problems;
// time complexity is O(n)
// space complexity is O(n)

// Implementing a hash map with linked list (Using linked list when collision occurs)
public class MyHashMap {
    
    // Creating Node for Linked Lists
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val) {
            
            this.key = key;
            this.val = val;
            
        }
    }
    
    private Node [] nodes;
    private int buckets;
    
    public MyHashMap() {
        
        buckets = 10000;
        nodes = new Node[buckets];
        
    }
    
    // Caluclating the hash function
    private int hash(int key) {
        
        return key % buckets;
        
    }
    
    // checking if the linked list is created at the specific index
    public Node find (Node head, int key) {
        
        Node prev = null;
        Node current = head;
        
        while (current != null && current.key != key) {
            
            prev = current;
            current = current.next;
            
        }
        
        return prev;
        
    }
    
    // performing the add operation for a hashmap
    public void put(int key, int value) {
        
        int index = hash(key);
        if (nodes[index] == null) {
            
            nodes[index] = new Node(-1,-1);
            
        }
        Node prev = find (nodes[index], key);
        
        if (prev.next == null) {
            
            prev.next = new Node(key, value);
            
        } else {
            
            prev.next.val = value;
            
        }
        
    }
    
    // performing search operation in a hashmap
    public int get(int key) {
        
        int index = hash(key);
        if (nodes[index] == null) return -1;
        Node prev = find(nodes[index], key);
        
        if (prev.next == null) return -1;
        return prev.next.val;
        
    }
    
    // performing pop opertion in a hashmap
    public void remove(int key) {
        
        int index = hash(key);
        if (nodes[index] == null) return;
        Node prev = find(nodes[index], key);
        
        if (prev.next == null) return;
        prev.next = prev.next.next;
        
    }

    public static void main (String [] args) {

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */