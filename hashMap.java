// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
class hashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node [] storage;
    public hashMap() {
        this.storage = new Node[10000];
    }
    private int hashIndex(int key){
        return key%10000;
    }
    private Node search( Node head ,int key){
        // give the prev node to current key we are searching
        Node prev = head;
        Node cur = head.next;
        while (cur != null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hashIndex(key);
        if (storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = search(storage[idx],key);
        // fresh key which does not exist
        if (prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hashIndex(key);
        if (storage[idx] == null) return -1;
        Node prev = search(storage[idx],key);
        if (prev.next == null){
            return -1;
        }else{
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int idx = hashIndex(key);
        if (storage[idx] == null) return;
        Node prev = search(storage[idx],key);
        if (prev.next == null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}
