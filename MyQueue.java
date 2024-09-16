// Time Complexity: For each push we need to perform a reversal of whole list twice, once popping all elements from main stack to temporary stack, then pushing new element at 0th position and again pushing all element from temporary stack back to original, both operation will perform with n elements and O(1) operation time ie. O(n).
// Space Complexity: we need 2 stacks of size n so O(2) can be considered O(n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    // Implemented a 2 stack approach to maintain a queue based operation of First in first out. reverse stack holds original(queue) stack values and stack contains temporary stack by popping all values from reverse
    Stack<Integer> stack;
    Stack<Integer> reverse;

    /** Initialize your data structure here. */
    public MyQueue() {
        // Initializing both stacks with a new Stack object
        stack = new Stack<>();
        reverse = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // In case there are no elements present in original stack, we can not pop anything
        // so just pushing in such case.
        if(reverse.isEmpty()) {
            reverse.push(x);
        } else {
            // otherwise untill the original stack is empty we pop each element and push it
            // to temporary stack - n times O(1) - O(n)
            while(!reverse.isEmpty()) {
                stack.push(reverse.pop());
            }
            // at 0th position of original stack we push the new element - O(1)
            reverse.push(x);
            // now reverse again to get the original stack on top of new element
            // n times O(1) - O(n)
            while(!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // a queue is already created using stack, taking out top element will give
        // the element which was first pushed in stack - O(1)
        return reverse.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        // a queue is already created using stack, peeking top element will give
        // the element which was first pushed in stack - O(1)
        return reverse.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        // simple isEmpty operation of stack returns this boolean value - O(1)
        return reverse.isEmpty();
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