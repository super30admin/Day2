// Time Complexity :O(1) for put, get, remove
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some pointer issues while coding put operation.


// Your code here along with comments explaining your approach

class MyHashMap {
    class Node{

        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;

            this.next = null;
        }
    }

    int buckets;
    Node[] storage;


    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    public int getBucket(int key){
        return key % buckets;
    }

    public Node find(Node head, int key){ // head is dummy node

        Node prev = head;
        Node current = head.next;

        while(current != null && current.key != key){

            prev = current;
            current = current.next;

        }

        return prev;

    }

    public void put(int key, int value) {

        int bucket = getBucket(key);
        Node newNode = new Node(key, value);

        if(storage[bucket] == null){

            Node dummy = new Node(-1,-1);
            storage[bucket] = dummy;
            dummy.next = newNode;

        }else{

            Node prev = find(storage[bucket], key);


            if(prev.next == null){
                prev.next = newNode;
            }else{
                prev.next.value = value;
            }
        }

    }

    public int get(int key) {

        int bucket = getBucket(key);

        if(storage[bucket] != null){

            Node prev = find(storage[bucket], key);

            if(prev.next != null){
                return prev.next.value;
            }else{
                return -1;
            }

        }else{
            return -1;
        }
    }

    public void remove(int key) {

        int bucket = getBucket(key);

        if(storage[bucket] != null){

            Node prev = find(storage[bucket], key);

            if(prev.next != null){
                prev.next =prev.next.next;
            }else{
                return; // Node with the provided key does not exist
            }

        }else{
            return;
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