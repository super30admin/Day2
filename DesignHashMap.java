// Time Complexity : O(1) O(100)=constant =O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Debugging when test cases with more than 1000 calls fails


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    Node[] storage;
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }
    private int getHash(int key){
        return key%buckets;
    }

    private Node getprev(int key){
        Node prev = storage[getHash(key)];
        if(prev==null) return null;
        Node curr = prev.next;

        while(curr!=null && curr.next!=null){
            if(curr.key==key) return prev;
            prev=curr;
            curr=curr.next;
        }
        return prev;
        
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if(storage[hash]==null){
            Node dummy = new Node(-1,-1); //start with dummy node
            Node nw = new Node(key, value);
            storage[hash] = dummy;
            dummy.next=nw;
            return;
        }
        Node prev = getprev(key);
        if(prev.next!=null && prev.next.key==key){
            prev.next.value=value; //replace value
            return;
        }
        Node nw = new Node(key,value);
        if(prev.next==null) prev.next=nw; //if only dummy node is there
        else prev.next.next=nw;
        
    }
    
    public int get(int key) {
        Node prev = getprev(key);
        if(prev==null){
            return -1;
        }
        if(prev.next!=null && prev.next.key==key)
            return prev.next.value;
        return -1;
    }
    
    public void remove(int key) {
        Node prev = getprev(key);
        if(prev==null) return;

        Node curr=prev.next;
        if(prev.next!=null && prev.next.key==key){
            prev.next=prev.next.next;
            curr.next=null;
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
