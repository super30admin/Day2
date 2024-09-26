// Time Complexity : For push, peek, and empty = O(1) and for pop O(n)
// Space Complexity : O(n + n) => O(2n) => O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I have designed Queue data structure using two stacks, one stack is for pushing elements and other stack is
for popping elements. When pushing elements, the element is pushed to Stack1. As stack is LIFO data structure,
whereas queue if FIFO. So there would be logic difference while popping the element. To implement this logic
I will push all elements from Stack1 to Stack2 if Stack2 is empty. Else we can directly pop from Stack2.
 */


class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        this.stack1.push(x);
    }

    public int pop() {
        this.peek();
        return this.stack2.pop();
    }

    public int peek() {
        if(this.stack2.isEmpty()){
            while(!this.stack1.isEmpty()){
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.peek();
    }

    public boolean empty() {
        if(this.stack1.isEmpty() && this.stack2.isEmpty()){
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