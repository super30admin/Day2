    // Time Complexity : O(1)  O(1)amortized for queue using stack
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    private int bucketfn(int key){
        return key % buckets;
    }
    private int bucketItemfn(int key){
        return key / bucketItems;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
        
    }
    
    public void add(int key) {
        int bucket = bucketfn(key);
        int bucketItem = bucketItemfn(key);
        
        if(storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        
        
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = bucketfn(key);
        int bucketItem = bucketItemfn(key);
        if(storage[bucket]== null) return;
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketfn(key);
        int bucketItem = bucketItemfn(key);
        if(storage[bucket]== null)
            return false;
         
            return storage[bucket][bucketItem];
    
        
           
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int top = peek();
        return(out.pop());
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */