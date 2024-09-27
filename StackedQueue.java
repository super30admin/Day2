// I need to implement queue using stack. Stack is a LIFO manner data structure and queue is FIFO. In Queue the element which is inserted first is removed first. 


//Time Complexity: 
    //  Push: O(1)
    // Pop: O(1), worst case pop time complexity is O(N). 
    // Such a time complexity is amortized time complexity.
    
//Space Complexity: O(N)
//Does this code run on Leetcode: Yes
//Any problems faced while executing: No



class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        
    }
    
    public void push(int x) {
            stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty() && !stack1.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty() && !stack1.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

       return stack2.peek();
    }
    
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
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
