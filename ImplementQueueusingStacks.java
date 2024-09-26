// Time Complexity : o(1) for push , o(n) for pop is stack empty otherwise o(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyQueue {

    /** Initialize your data structure here. */

    Stack<Integer> st1 ,st2;

    public MyQueue() {

        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
            st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.pop();

    }

    /** Get the front element. */
    public int peek() {

        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (st1.size()==0 && st2.size() ==0);
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
