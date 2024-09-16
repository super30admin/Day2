// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

1. Queue using stack
 // I am using two stacks in stack for push and out stack for the peek or pop()
//if it is push operation just push into instack
//if it is pop or peek operation just checks whether out stack is empty if not just pops or gets peek if it is empty
// will get all the elements from the in stack to out stack and performs the operations.

//Time complexity best case or average case O(1) for all the operations
//O(n) worst case for peek ans pop operations when continues push and pops happens
//Space complexity is O(1)

//It ran successfully on leetcode and no problems observed
class MyQueue {
    private Stack<Integer>in;
    private Stack<Integer>out;


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
        if(in.isEmpty()&&out.isEmpty()){
            return -1;
        }
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(in.isEmpty()&&out.isEmpty()){
            return -1;
        }
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
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


2.  HashSet

// using boolean 2-D array for Hashset
//Time complexity o(1) for all the operations
// space complexity is O(1) bacause we have constant sizes of 1000.
//Ran successfully on leetcode - no issues observed.
class MyHashSet {
    boolean store[][];
    int buckets;
    int bucketElements;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        store=new boolean[buckets][];
        bucketElements=1000;

    }

    public void add(int key) {
        int bucket=key%buckets;
        int element=key/bucketElements;
        if(store[bucket]==null){
            if(bucket==0){
                store[bucket]=new boolean[bucketElements+1];
            }else{
                store[bucket]=new boolean[bucketElements];
            }
        }
        store[bucket][element]=true;

    }

    public void remove(int key) {

        int bucket=key%buckets;
        int element=key/bucketElements;
        if(store[bucket]==null)
            return;
        store[bucket][element]=false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=key%buckets;
        int element=key/bucketElements;
        if(store[bucket]==null)
            return false;
        return store[bucket][element];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */