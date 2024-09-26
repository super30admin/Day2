// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//706. Design HashMap

class MyHashMap {
    
    class Node{
        int key, value;
        Node next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    int buckets;
    Node[] hashMap;
    
    private int getBucket(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find( Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while((curr!=null)&&(curr.key!=key)){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public MyHashMap() {
        buckets = 10000;
        hashMap = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        Node p;
        if (hashMap[bucket] == null){
            hashMap[bucket] = new Node(-1, -1);
            //p = hashMap[bucket];
        }
        p = find(hashMap[bucket], key);
        if(p.next == null){
            p.next = new Node(key, value);
        }
        else{
            p.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        Node p;
        if (hashMap[bucket] == null){
            return -1;
        }
        p = find(hashMap[bucket], key);
        if(p.next == null){
            return -1;
        }
        return p.next.value;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        Node p;
        if (hashMap[bucket] == null){
            return;
        } 
        p = find(hashMap[bucket], key);
        if(p.next == null){
            return;
        }
        else{
            p.next = p.next.next;
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