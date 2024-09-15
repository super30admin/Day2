// Time Complexity : The time complexities for push and empty operations is O(1)
// The time complexities for pop and peek operations is O(n) since we are removing each element from one array and pushing into the other.
// Space Complexity : The space complexity is O(n) since we are using stack to implement a Queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        // Pushes to the top of stack
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        // Remove the elements from one stack and move them to the other stack so that the first added element comes to the top
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();

    }

    /** Get the front element. */
    public int peek() {

        // Remove the elements from one stack and move them to the other stack so that the first added element comes to the top
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        // Queue is empty if both the stacks are empty
        if(stack1.isEmpty() && stack2.isEmpty()){
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
