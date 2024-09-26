// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    // two separate queues for push and pop actions
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    private void transfer(){ // transfers all elements from push stack to pop stack, so the elements are arranged in the reverse order to help with de-queue
        while(!pushStack.empty()){
            popStack.push(pushStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if pop stack is empty, transfer elements from push stack to pop the first element of the queue
        if(!empty()){
            if(popStack.empty()){
                transfer();
            }
            return popStack.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        // return -1 if both the stacks are empty
        if(empty()) return -1;

        // else if the pop stack is empty, transfer elements from push stack to get the first element
        if(popStack.empty()){
            transfer();
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (popStack.empty() && pushStack.empty());
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