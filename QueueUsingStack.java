import java.util.Stack;

class MyQueue {

    /**
     * Approach: Use 2 stacks
     *
     * Enqueue: Is directly push in to stack1.
     *
     * Dequeue: If  stack2==empty then pop stack1 and push to stack 2 untill the element is found. else pop from stack2
     *
     *Time complexity : O(1)
     *
     * Space complexity: O(1)
     */
    private Stack<Integer> stack1;
    private  Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek();
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return  stack1.isEmpty()  && stack2.empty();

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