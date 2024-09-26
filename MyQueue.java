// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> fifo_stack;
    public MyQueue() {
        stack = new Stack<Integer>();
        fifo_stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if(fifo_stack.isEmpty()){
            while(stack.size()!=0){
                fifo_stack.push(stack.pop());
            }
        }
        return fifo_stack.pop();

    }

    public int peek() {
        if(fifo_stack.isEmpty()){
            while(stack.size()!=0){
                fifo_stack.push(stack.pop());
            }
        }
        return fifo_stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && fifo_stack.isEmpty();
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