// Time Complexity : O(1) for push and  isempty, pop and peek amortized time O(1), worst case(n),
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<Integer>();
        out= new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //if out stack is empty move all the elements form in stack to out
        // by calling peek method
        if(out.isEmpty()){
            peek();
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        //if out stack is empty, then move all the elements form in stack to out
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