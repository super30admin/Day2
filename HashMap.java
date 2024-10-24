// Time Complexity : O(1) for average case and worse case time Complexity O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class HashMap {
    private static class Node{
        int key, value;
        Node next;

        Node(int key,int value){
            this.key = key;
            this.value= value;
            this.next = null;

        }
    }

    private static final int DEFAULT_CAPACITY = 10000; // Capacity set to 10,000
    private Node[] table;// Array to store the linked ;list

    //Constructor
    public HashMap(){
        this.table = new Node[DEFAULT_CAPACITY];

        // initialize each bucket with a dummy node
        for (int i =0; i<DEFAULT_CAPACITY; i++){
            table[i] = new Node(-1,-1); // dummy node with key -1 and value -1
        }
    }
    // hash function to determine the index of an array
    private int hash(int key){
        return key% DEFAULT_CAPACITY;
    }
    // Function to find previous node of given key in linked list at a specific bucket
    private Node getPrev(int key, int index) {
        Node prev = table[index]; // get dummy head of the bucket
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
    //insert a key value pair
    public void put(int key, int value) {
        int index = hash(key); // get bucket index
        Node prev = getPrev(key, index);

        // check if the key already exists
        if (prev.next == null) {
            // key is not found , insert
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    public int get(int key) {
        int index = hash(key);
        Node prev = getPrev(key, index);
        if (prev.next != null) {
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node prev = getPrev(key, index);
        if (prev.next != null) { // if key exist, remove the node by skipping it
            prev.next = prev.next.next;
        }
    }
    // Main method to test MyHashMap with the given constraints
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        // Testing with key and value range constraints
        hashMap.put(1, 100);
        hashMap.put(1000000, 500);
        hashMap.put(500, 999);

        // Get values for keys within the constraints
        System.out.println("Value for key 1: " + hashMap.get(1)); // Should print 100
        System.out.println("Value for key 1000000: " + hashMap.get(1000000)); // Should print 500
        System.out.println("Value for key 500: " + hashMap.get(500)); // Should print 999

        // Update the value for key 500
        hashMap.put(500, 888);
        System.out.println("Updated value for key 500: " + hashMap.get(500)); // Should print 888

        // Remove key 1 and try getting its value
        hashMap.remove(1);
        System.out.println("Value for key 1 after removal: " + hashMap.get(1)); // Should print -1

        // Check handling of a non-existing key
        System.out.println("Value for key 12345: " + hashMap.get(12345)); // Should print -1

        // Insert and retrieve a large key-value pair
        hashMap.put(999999, 200);
        System.out.println("Value for key 999999: " + hashMap.get(999999)); // Should print 200

        // Insert multiple keys to simulate the constraints
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, i * 2);
        }
        System.out.println("Value for key 9999: " + hashMap.get(9999)); // Should print 19998
    }
}
