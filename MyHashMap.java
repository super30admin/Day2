/*
 * Time Complexity :O(1) for push,get,remove amortised
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : YES
 * Any problem you faced while coding this :Extremely lengthy
 */
class MyHashMap {
    class Node{
        int key,value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int buckets;
    Node[] storage;

     int getBucketKey(int key){
        return Integer.hashCode(key)%this.buckets;
    }

    private Node find(Node dummy,int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBucketKey(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket],key);
        if(prev.next != null){
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        int bucket = getBucketKey(key);
        if(storage[bucket]==null){
            return -1;
        }       
        Node prev = find(storage[bucket],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucketKey(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket],key);
        if(prev.next!=null){
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