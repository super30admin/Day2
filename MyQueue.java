// Time Complexity : push O(1) pop: best O(1) worst O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    public void push(int x) {
        this.pushStack.push(x);
    }

    public int pop() {
        if(this.popStack.isEmpty()){
            while(!this.pushStack.isEmpty()){
                this.popStack.push(this.pushStack.pop());
            }
        }

        return this.popStack.pop();
    }

    public int peek() {

        if(this.empty()) return -1;

        if(this.popStack.isEmpty()){
            while(!this.pushStack.isEmpty()){
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.peek();
    }

    public boolean empty() {
        return this.pushStack.isEmpty() && this.popStack.isEmpty();
    }
}
