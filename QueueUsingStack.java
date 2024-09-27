// Time Complexity : O(1) for push Operation, O(1) for pop Operation
/* Since two stacks are used while finding the peek/ pop operation in best case it takes O(1) even for peek and Pop Operation. It takes O(1) for Push operation constantly */
// Space Complexity : O(1)
/* Since using two stacks for peek/pop operation, space complexity is O(n) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/* I tried two stacks for push operation, it takes O(n) time complexity for push Operation. */
/* Then I used two stacks for peek/pop operation, so in best case it takes O(1) for push,pop,peek operations */


// Your code here along with comments explaining your approach

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in,out;
    public MyQueue() {
        in = new Stack();
        out = new Stack();
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
        return (out.isEmpty() && in.isEmpty());
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
