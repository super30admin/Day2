//Time Complexity : O(1)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class MyQueue {
    //declaring the stacks for FIFO
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
    //intializing the stacks
        stack1= new Stack<>();
        stack2= new Stack<>();
    }
    
    public void push(int x) {
    //inserting the given value into 1st stack
        stack1.push(x);
    }
    
    public int pop() {
    //deleting the 1st inserted element 
        peek();
        return stack2.pop();
    }
    
    public int peek() {
    //check the stack2 is empty or not, when stack1 is not empty we push the value that is deleted from stack1 into stack2
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    //and we return the first element of the queue
    return stack2.peek();
    }
    
    public boolean empty() {
    //checks if both stacks are empty or not, then we can say queue is empty
        return stack1.isEmpty() && stack2.isEmpty();
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