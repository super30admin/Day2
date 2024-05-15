// Time Complexity : put-O(n), get-O(n), remove-O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wrong Answers. wrote find() wrong.


// Your code here along with comments explaining your approach

// Designed using seperate chaining (uisng Linkedlist) to avoid collision.

class MyHashMap {

    class Node{
        int key, value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int buckets;
    Node[] storage;

    public MyHashMap() {

        this.buckets = 10000;
        storage = new Node[buckets];
    }

    int getBucket(int key){
        return key % buckets;
    }

    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {

        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key,value);
        }

    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {

        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return ;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null){
            prev.next = prev.next.next;
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