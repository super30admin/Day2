// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 HashMap is used for fast access of data. While designing Hashmap below points needs to consider

 1. Primary Datastructure - I will be using array
 2. Primary Datastructure size -> We need to select size in such a way both primary and secondary buckets are balanced. If we are using double hashing technique size of the primary bucket array can be 1000. And with linear chaining, we can has primary bucket size as 10000. Since it uses LinkedList, we can reduce the search on linked list.
 3. HashFunction -> we need to define hash function in such a way that it should return unique index always. and it should return the same output for the same input. Values should be within the range of the array size.
 */
class MyHashMap {

    int buckets;
    Node[] storage;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key,int value) {
            this.key = key;
            this.value= value;
        }
    }
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[10000];
    }

    private int getHash(int key){
        return key % buckets;
    }

    private Node findPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        if(storage[hash] == null ) {
            storage[hash] = new Node(-1,-1);
        }

        Node prev = findPrev(storage[hash], key);
        if(prev.next == null) {
            prev.next = new Node(key,value);
        }else {
            prev.next.value = value; //overriding existing key with given value.
        }
    }

    //O(1)
    public int get(int key) {
        int hash = getHash(key);
        if(storage[hash] == null){
            return -1;
        }
        Node prev = findPrev(storage[hash], key);
        if(prev.next == null) {
            return -1;
        }else{
            return prev.next.value;
        }
    }

    //O(1)
    public void remove(int key) {
        int hash = getHash(key);
        if(storage[hash] == null) {
            return;
        }
        Node prev = findPrev(storage[hash], key);
        if(prev.next == null) {
            return;
        }
        Node curr = prev.next;
        prev.next = prev.next.next;
        curr = null;
    }
}