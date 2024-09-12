// Time Complexity : O(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    private int top;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        if(st1.isEmpty()){
            top = x;

        }

        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        st2.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }


    /** Removes the element from in front of queue and returns that element. */
    public int pop()
    {
        return st1.pop();
//         if(!st1.isEmpty()){
//             front = st1.peek();
//         }


    }
    /** Get the front element. */
    public int peek() {
        return st1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        return st1.isEmpty();
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