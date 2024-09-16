import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int value=-1;
        if(stk2.isEmpty()){
            if(!stk1.isEmpty()){
                while(!stk1.isEmpty()){
                    stk2.push(stk1.pop());
                }
            }
        }
        if(!stk2.isEmpty()){
            value= stk2.pop();
        }
        return value;
    }



    /** Get the front element. */
    public int peek() {
        int value=-1;
        if(stk2.isEmpty()){
            if(!stk1.isEmpty()){
                while(!stk1.isEmpty()){
                    stk2.push(stk1.pop());
                }
            }
        }
        if(!stk2.isEmpty()){
            value= stk2.peek();
        }
        return value;
    }



    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stk1.isEmpty() && stk2.isEmpty()){
            return true;
        }
        return false;
    }
}
