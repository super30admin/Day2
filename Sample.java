import java.util.*;
//Problem1
// Time Complexity :amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.add(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty() && !stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
        else if (!stack2.isEmpty()){
            return stack2.pop();
        }
        else
            return -1;
        
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty() && !stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.peek();
        }
        else if (!stack2.isEmpty()){
            return stack2.peek();
        }
        else
            return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty()); 
        
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

 //Problem2
// Time Complexity : O(1)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private int bucket = 1000;
    private int bucketList = 1000;
        
        
    private int hashFunction1(int key){
        return key%bucket;
    }
        
    private int hashFunction2(int key){
        return key/bucket;
    }
        
    private boolean[][] hashSet;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[bucket][];
        
    }
    
    public void add(int key) {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if(hashSet[index1] == null){
            hashSet[index1] = new boolean[bucketList];
        }
        hashSet[index1][index2] = true;
        
    }
    
    public void remove(int key) {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if(hashSet[index1] != null){
            hashSet[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if(hashSet[index1] != null){
            return hashSet[index1][index2];
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */