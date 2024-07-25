// Time Complexity : O(1) - LL max size is 100 always
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    Node[] storage;
    static int bucketSize = 10000;

    class Node{
        int key; int value;
        Node next;

        public Node(int k,int v){
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    public MyHashMap() {
        storage = new Node[bucketSize];
    }

    private int getBuckets(int key){
        return key%bucketSize;
    }

    private Node search(Node head,int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bk = getBuckets(key);
        if(storage[bk]==null){
            storage[bk] = new Node(-1,-1);
        }
        Node prev = search(storage[bk],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        } else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bk = getBuckets(key);
        if(storage[bk]==null){
            return -1;
        }

        Node prev = search(storage[bk],key);
        if(prev.next == null)
            return -1;
        
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bk = getBuckets(key);
        if(storage[bk]==null) return;

        Node prev = search(storage[bk],key);
        if(prev.next == null) return;

        Node delete = prev.next;
        prev.next = prev.next.next;
        delete.next = null;
    }
}