// TIME: O(1)
// SPACE: O(n)
// SUCCESS on LeetCode
class MyQueue {
    private Stack<Integer> enqueueStack; // using one stack to enqueue
    private Stack<Integer> dequeueStack; // using one stack to dequeue

    /** Initialize your data structure here. */
    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enqueueStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (dequeueStack.isEmpty()) { // if dequeue stack is empty, then all the elements from enqueue stack will be popped and pushed into the dequeue stack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.pop();
        } 
        return dequeueStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.peek();
        } 
        return dequeueStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
