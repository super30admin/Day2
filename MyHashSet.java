// Time Complexity : O(1) for add on Average case and O(N) on worst case, O(1) for remove on Average case and O(N) on worst case, O(1) for contains on average case and O(N) on worst case.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class MyHashSet {
    
    Node[] set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new Node[9997];
    }
    
    public int hash(int key){
        return key%9997;
    }
    
    public void add(int key) {
        int hash = hash(key);
        if(null == set[hash]){
            set[hash] = new Node(null);
        }
        Node start = set[hash], current = start.next, prev = start;
        if(null == current){
            start.next = new Node(key);
            return;
        }
        while(null != current){
            if(current.value == key){
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = new Node(key);
    }
    
    public void remove(int key) {
        int hash = hash(key);
        if(null == set[hash]){
            set[hash] = new Node(null);
            return;
        }
        Node start = set[hash], current = start.next, prev = start;
        while(null != current){
            if(current.value == key){
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        if(null == set[hash]){
            return false;
        }
        Node start = set[hash], current = start.next, prev = start;
        while(null != current){
            if(current.value == key){
                return true;
            }
            prev = current;
            current = current.next;
        }
    return false;
    }
    
    class Node{
        Integer value;
        Node next;
        public Node(Integer value){
            this.value = value;
            next = null;
        }
    }
    
}