// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> st1;
    Stack<Integer> st2;
    int temp;

    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    /* Method to transfer elements from Stack 1 to Stack 2 if Stack 2 is not empty.
    Pop one at a time. This reverses the order of elements in Stack 2.
    Called during POP and PEEK */
    public void transfer(){
        temp = 0;

        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                temp = st1.pop();
                st2.push(temp);
            }
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transfer();
        return st2.pop();
    }

    /** Get the front element. */
    public int peek() {
        transfer();
        return st2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(st1.isEmpty() && st2.isEmpty())
            return true;
        else
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