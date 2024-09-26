// Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implementing Queue using 2 Stacks
class MyQueue {
    Stack<Integer> queue1;
    Stack<Integer> queue2;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue1 = new Stack<>();
        queue2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!queue1.isEmpty()) {
            queue2.push(queue1.pop());
        }
        
        int front = queue2.pop();
        
        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }
        
        return front;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!queue1.isEmpty()) {
            queue2.push(queue1.pop());
        }
        
        int front = queue2.peek();
        
        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }
        
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue1.isEmpty();
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


// Problem 2
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implementing HashSet using HashMap
 class MyHashSet {
    
    private int bucket = 1000;
    private int bucketItem = 1000;
    
    private int hashFunc1(int key) {
        return key % bucket;
    }
    
    private int hashFunc2(int key) {
        return key / bucketItem;
    }
    
    private boolean[][] hashSet;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[bucket][];
    }
    
    public void add(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if (hashSet[index1] == null) {
            hashSet[index1] = new boolean[bucketItem];
        }
        hashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if (hashSet[index1] == null) {
            return;
        }
        hashSet[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        return hashSet[index1] != null && hashSet[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */