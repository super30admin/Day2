// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        // s1.push(temp);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        s1.push(temp);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
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