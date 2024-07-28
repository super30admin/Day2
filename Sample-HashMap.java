// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I did not understand this in the regular class, 
// I had to go over the video recording again to understand. Used the same approach as Jaspinder used.

class MyHashMap {
    class Node{
        int key, val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node [] storage; 
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    private int hash(int key){
        return key % buckets;
    }

    private Node search(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = search(storage[bucket],key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return -1 ;

        Node prev = search(storage[bucket], key);

        if(prev.next == null) return - 1;

        return prev.next.val;
    }


    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return;

        Node prev = search(storage[bucket], key);
        if(prev.next == null) return;

        Node curr = prev.next;
        prev.next = prev.next.next;
        curr.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */