/* Problem: Implement queue using stacks" */
// Time Complexity : O(1)
// Space Complexity : O(n) as we use additional stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Approach:
//1. Use two stacks. The elements are initially pushed into the first stack.
//2. However, to pop the element from queue(FIFO), we make use of second stack
//3. The second stack basically acts like an inverted stack of the first stack so that the popped element from the first stack sits at the bottom of the second stack and the last element in the first stack comes to be on top of second stack. This implements the FIFO nature of queue.
class MyQueue {
    
    /** Initialize your data structure here. */
    
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.isEmpty()) {
            while(!st1.empty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if(st2.isEmpty()) {
            while(!st1.empty()) {
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



 /* PROBLEM 2: Implement HashSet */
//Time Complexity : O(1)
// Space Complexity : O(n^2) as we use n * n matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach : Makes use of 2 hashing functions.
//We use the second hashing function only when there are collisions. Else one hashing function is sufficient. 
//Here, in hashset, we don't need to get the value, we just need to see if the element is present or not. Hence we use a boolean array of 2-dimensions.

 class MyHashSet {
    int bucketSize = 1000;
    int numBuckItems = 1000;
    boolean[][] bucket = new boolean[bucketSize][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private int hash1(int key) {
        return key % bucketSize;
    }
    
    private int hash2(int key) {
        return key / bucketSize;
    }
    
    public void add(int key) {
        int bucketPos1 = hash1(key);
        int bucketPos2 = hash2(key);
        if(bucket[bucketPos1] == null) {
            bucket[bucketPos1] = new boolean[numBuckItems];
        }
        bucket[bucketPos1][bucketPos2] = true; // we don't need to insert the original element because we already know that all the positions contain unique elements because each key has a unique index from 2 hash func.
    }
    
    public void remove(int key) {
        int bucketPos1 = hash1(key);
        int bucketPos2 = hash2(key);
        if(bucket[bucketPos1]!=null) {
            bucket[bucketPos1][bucketPos2] = false; // just update the value to be false. equivalent to removing it from the hashset.
        }
    }
    
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketPos1 = hash1(key);
        int bucketPos2 = hash2(key);
        return bucket[bucketPos1] != null && bucket[bucketPos1][bucketPos2]; // returns true if the position is not null and contains the element.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */