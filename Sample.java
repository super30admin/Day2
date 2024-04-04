// Time Complexity : O(2N)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.add(x); //O(N)
    }
    
    public int pop() { ///O(2N)
        int val = -1;
        stack2 = new Stack();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());//O(N)
        if (!stack2.isEmpty())
            val = stack2.pop();
        while (!stack2.isEmpty()) //O(N)
            stack1.push(stack2.pop());

        return val;
    }
    
    public int peek() {
        int val = -1;
        stack2 = new Stack();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        if (!stack2.isEmpty())
            val = stack2.peek();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

        return val;
    }
    
    public boolean empty() {
        if (stack1.isEmpty())
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
