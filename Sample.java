// Submitting again via CMD - 27dec

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : 0(2n) i.e 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        st1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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


## Problem 2:(https://leetcode.com/problems/design-hashset/)
 // Time Complexity : 0(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] hset;
    private int buckets;
    private int subbuckets;
    /** Initialize your data structure here. */
    private int bucket(int key){
        return key % buckets;
    }
    
    private int subbucket(int key){
        return key / subbuckets;
    }
    
    public MyHashSet() {
        buckets=1000;
        subbuckets=1000;
        hset = new boolean [buckets][];
    }
    
    
    public void add(int key) {
        int i = bucket(key);
        int j = subbucket(key);
        if(hset[i] == null){
            hset[i] = new boolean[subbuckets];
        }
        hset[i][j] = true;
    }
    
    public void remove(int key) {
        int i = bucket(key);
        int j = subbucket(key);
        if (hset[i]==null) return;
        hset[i][j]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = bucket(key);
        int j = subbucket(key);
        if (hset[i] == null) return false;
        return hset[i][j];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */