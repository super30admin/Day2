// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class MyQueue {
    //stack in for pushing elements to stack and out for pop.
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        //Initializing both the stacks
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        //pushing element into in stack.
        in.push(x);
    }

    public int pop() {
        //calling peek method to check if the out stack is empty and if there are elements in in stack to fill in out
        peek();
        //returning the top element of out stack
        return out.pop();
    }

    public int peek() {
        //if out stack is empty, pop out elements in in stack one by one and push to out.
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        //if both the stacks are empty, then the queue is empty
        return (in.isEmpty() && out.isEmpty());
    }
}