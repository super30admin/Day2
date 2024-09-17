// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : While adding new element in LinkedList of LinkedList all the elements after the index I added were shifted only after adding some numbers
Used arrays instead LinkedList. Array of LinkedList worked properly
*/


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Your code here along with comments explaining your approach
class MyHashSet {
    private int numBuckets = 15000;
    List<Integer>[] buckets;

    private int hash_function(int key){
        return key % numBuckets;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[numBuckets];
    }

    public void add(int key) {
        int i = hash_function(key);
        if(buckets[i] == null) buckets[i] = new LinkedList<>();
        if(buckets[i].indexOf(key) == -1)
            buckets[i].add(key);
    }

    public void remove(int key) {
        int i = hash_function(key);
        if(buckets[i] == null) return;
        if(buckets[i].indexOf(key) != -1) buckets[i].remove(buckets[i].indexOf(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash_function(key);
        if(buckets[i] == null || buckets[i].indexOf(key) == -1) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//Implement Queues using Stacks
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes

class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    public MyQueue() {
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
