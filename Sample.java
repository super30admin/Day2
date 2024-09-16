// Time Complexity : O(1) for insertion deletion
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class MyHashSet {
    
    boolean storage[][];
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage=new boolean[buckets][];
        
    }
    
    public void add(int key) {
        int bucket= bucket(key);
        int bucketItem =bucketItems(key);
        
        if(storage[bucket]==null){
            storage[bucket]=new boolean [bucketItems];
        }
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket= bucket(key);
        int bucketItems =bucketItems(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItems]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket= bucket(key);
        int bucketItem =bucketItems(key);
        if(storage[bucket]==null)
        {
            return false;
        }
        else if (storage[bucket][bucketItem]==true){
            return true;
                }
        return false;
        }
        
    
    
    public int bucket(int key){
        return key%buckets;
    }
    
    public int bucketItems(int key){
        return key/bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



// Time Complexity : O(1) for insertion deletion
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.*;
class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       int temp= peek();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }
        
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty())
            return true;
        return false;
        
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
