// Time Complexity : Push : O(1), Amortized POP O(1), Empty: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we use 2 stacks in and out to maintain the elements.  for every pop operation
// we pop all the elements from in stack and push them onto pop stack and pop the top of out stack
// if out stack is empty else we directly pop the out stack
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void push(int x) {
        in.push(x); // push element on to in stack
    }

    public int pop() {
        peek(); // use peek method to push elements from in stack to out stack if out is Empty
        return out.pop(); //else we directly pop the top of element from out stack
    }

    public int peek() {
        if(out.isEmpty()){ // check if out stack is empty. if it is
            while(!in.isEmpty()){
                out.push(in.pop()); // add elements from in stack by popping, to the out stack
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty(); //
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
