// Time Complexity : Total of  O(4n) ~ O(n)
// Space Complexity :O(1), No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

//Used Chaining
class MyHashMap {
    Node[] storage;
    int buckets;
    

    class Node{
        int key;
        int val;
        Node next;

        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[this.buckets];

    }
    //O(1)
    private int getBucket(int key){
        return Integer.hashCode(key)% this.buckets;
    }
    //O(n)
    private Node find(Node dummy, int key){
       // int bkt = getBucket(key);
       // Node dummy = new Node(-1,-1);
        Node prev = dummy;
        Node curr = dummy;

        while(curr!= null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;

    }
  //O(n)
    public void put(int key, int value) { 
        int buck = getBucket(key);
        if(storage[buck] == null){
            storage[buck] = new Node(-1,-1);
        }
        Node prev = find(storage[buck],key);
        if(prev.next == null){
            Node n = new Node(key,value);
            prev.next = n;
        }else{
            prev.next.val = value;
        }        
    }
  //O(n)
    public int get(int key) {
        int buck = getBucket(key);
        if(storage[buck] == null){
            return -1;
        }
        Node prev = find(storage[buck],key);

        if(prev.next == null){
            return -1;
        }
        
        return prev.next.val;        
    }
  //O(n)
    public void remove(int key) {
        int buck = getBucket(key);
        if(storage[buck] == null){
            return;
        }
        Node prev = find(storage[buck],key);
        if(prev.next == null){
            return;
        }else{            
            prev.next=prev.next.next;
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