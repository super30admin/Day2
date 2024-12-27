// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


/* Your code here along with comments explaining your approach
Have two stacks, in and out. Push all elements to in stack and until you encounter a pop.
For the first pop or peek, transfer all elements from in to out and then peek/pop the first element.
Continue moving the new elements to in stack for every push and pop from out stack from every pop until the out stack is empty.
If out stack is empty, push all elements from in stack to out stack and pop the first element */

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;


    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        peek();
        return this.out.pop();
    }

    //If out stack is empty, push all elements from in stack to out stack, this will move the last element to first.
    public int peek() {
        if(this.out.isEmpty())
        {
            while(!this.in.isEmpty())
            {
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
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