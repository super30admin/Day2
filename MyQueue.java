// Time Complexity : Ammortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    //Constructor
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }
    // Push element into stack1 which will be the back of the Queue
    public void push(int x){
        stack1.push(x);
    }

    public int pop() {
        peek();
        // return the top of stack 2
        return stack2.pop();
    }
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }



    // Main method to test the implementation
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        // Push elements to the queue
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        // Peek the front element
        System.out.println("Front element: " + myQueue.peek()); // Should print 1

        // Pop elements from the queue
        System.out.println("Popped element: " + myQueue.pop()); // Should print 1
        System.out.println("Popped element: " + myQueue.pop()); // Should print 2

        // Push another element
        myQueue.push(4);

        // Peek the front element
        System.out.println("Front element: " + myQueue.peek()); // Should print 3

        // Pop remaining elements
        System.out.println("Popped element: " + myQueue.pop()); // Should print 3
        System.out.println("Popped element: " + myQueue.pop()); // Should print 4

        // Check if the queue is empty
        System.out.println("Is queue empty? " + myQueue.empty()); // Should print true
    }
}
