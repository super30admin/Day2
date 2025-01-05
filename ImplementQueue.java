// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * In this problem I have implemented Queue(FIFO) using two Stacks. Elements are pushed into the first stack,
 * and when we need to pop or peek, we transfer elements to the second stack, reversing their order.
 * This way, we can simulate the behavior of a queue while maintaining the stack operations.
 */ 
class MyQueue {

    // Stack for incoming elements
    Stack<Integer> inStack;
    //Stack for outgoing elements
    Stack<Integer> outStack;

    // Constructor to initialize the two stacks
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    // Method to push an element into the queue
    public void push(int x) {
        // Push the element into inStack
        inStack.push(x);
    }
    
    // Method to pop an element from the queue 
    public int pop() {
        // If outStack is not empty, pop from outStack
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }

        // If outStack is empty, we need to transfer all elements from inStack to outStack
        // This step reversed the elements and simulates Queue behaviour.
        while (!inStack.isEmpty()) {
            // Pop from inStack and push onto outStack to reverse the order
            outStack.push(inStack.pop());
        }

        return outStack.pop();
    }
    
    // Method to peek at the front element of the queue
    public int peek() {
        // If outStack is not empty, just return the top element of outStack
        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else {
            // If outStack is empty, transfer all elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            // After transferring, return the front element from outStack
            return outStack.peek();
        }
    }
    
    // Method to check if the queue is empty
    public boolean empty() {
        // The queue is empty if both inStack and outStack are empty
        return inStack.isEmpty() && outStack.isEmpty();
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