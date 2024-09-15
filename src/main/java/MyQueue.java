// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    /** Created 2 stacks in and out. During push operations everything gets pushed in stack
     * and if peek or pop operation is called first we check if out stack is empty, if it is then
     * in stack is emptied into out stack which acts like a queue otherwise we return from out stack*/
    public MyQueue() {
        this.in=new Stack<>();
        this.out=new Stack<>();
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
        if(!out.isEmpty()){
            return out.peek();
        }else{
            while(!in.isEmpty()){
                out.push(in.pop());
            }

            return out.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }
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