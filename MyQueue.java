// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue { //initialising two stacks temp and value

    Stack<Integer> temp;
    Stack<Integer> value;

    /** Initialize your data structure here. */
    public MyQueue() {
        temp = new Stack<Integer>(); 
        value = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {  //for pushing to the back, checking if the value stack is empty
        if(value.isEmpty()){ //if true push x to value stack
            value.push(x);
        }else{ //else check until value stack is not empty and push the popped element from value to temp stack
            while(!value.isEmpty()){
                temp.push(value.pop());
            }

            value.push(x); //else push to value stack

            while(!temp.isEmpty()){  //else check until temp stack is not empty and push the popped element from temp to value stack
                value.push(temp.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() { //return popped element from value stack
        return value.pop();
    }

    /** Get the front element. */
    public int peek() { //returns the top element of value stack
        return value.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() { //checks whether value stack is empty
        return value.isEmpty();
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
