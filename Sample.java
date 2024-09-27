// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was initially thinking of pushing back all the elements to in stack after pop,
// but method discussed in class was more efficient, so implemented that here.


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

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
        peek();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {

    boolean[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new boolean[100];
    }

    public void add(int key) {
        if(key >= buckets.length)
            buckets = Arrays.copyOf(buckets, key + 1);
        buckets[key] = true;
    }

    public void remove(int key) {
        if(key < buckets.length)
            buckets[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if( key < buckets.length)
            return buckets[key];
        else
            return false;
    }
}

