// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// S30 ID: Sawan Chakraborty_RN69DEC2024

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
        public Node (int key, int value){ // Node definition
            this.key=key;
            this.value=value;
        }
    }

    int buckets;
    Node[] storage; // storage array 
    public MyHashMap() {
        this.buckets = 10000;
        storage = new Node[this.buckets];
    }

    private Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr=dummy.next;
        while(curr!=null && curr.key!=key){ //stops at prev of the node to be searched
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    private int getBucket(int key){ 
        return key % 10000; // geting bucket index
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            storage[bucket] = new Node(-1,-1); // dummy node creation
        }
        Node prev=find(storage[bucket],key);
        if(prev.next!=null){
            prev.next.value=value; // value updated of key
        }
        else{
            prev.next = new Node(key,value); // new node created
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
        return -1;
        }
        Node prev=find(storage[bucket],key);
        if(prev.next==null){
            return -1;
        }
        else
        return prev.next.value; // returns value
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
        return;
        }
        Node prev=find(storage[bucket],key);
        if(prev.next!=null){
            prev.next=prev.next.next;// skips the node
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