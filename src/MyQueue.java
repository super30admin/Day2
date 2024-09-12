// Time Complexity : Push = O(1)
//                   Pop = O(n)
//                   Peek = O(n)
//                   isEmpty = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

class MyQueue {

    Stack<Integer> pushS = new Stack<>();
    Stack<Integer> popS = new Stack<>();
    public MyQueue() {
    }

    public void push(int x) {
        pushS.push(x);
    }

    public int pop() {
        if(popS.isEmpty())
        {
            while(!pushS.isEmpty())
            {
                popS.push(pushS.pop());
            }
        }
        return popS.pop();
    }

    public int peek() {
        if(popS.isEmpty())
        {
            while(!pushS.isEmpty())
            {
                popS.push(pushS.pop());
            }
        }
        return popS.peek();
    }

    public boolean empty() {
        if(popS.isEmpty() && pushS.isEmpty())
        {
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