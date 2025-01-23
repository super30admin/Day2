import java.util.Stack;
// Time Complexity : push - O(n) pop - O(1) peek - O(1) empty - O(1)
// Space Complexity : O(2*n) space complexity.
// Did this code successfully run on Leetcode : yes, I did run.
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
class MyQueue {
    /* I have used two stacks, one is for maintaining the elements, the other one is just a holder for the existing elements till push of new element is done into stk1*/
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    //when there is a push operation, first i'm transferring the elements from stack1 to stack2 and pushing the new element into the stack1 and then retransfer the previously existed elements from stack2 to stack1.
    //transferring is necessary inorder to maintain the order of elements entering the stack.
    public void push(int x) {
        if(!stk1.isEmpty())
        {
            while(!stk1.isEmpty())
            {
                stk2.push(stk1.peek());
                stk1.pop();
            }
                
            stk1.push(x);

            while(!stk2.isEmpty())
            {
                stk1.push(stk2.peek());
                stk2.pop();
            }
        }
        else
        stk1.push(x);
    }
    //As at every point of time the stack1 contains the first entered element on the top, we can just pop it out.
    public int pop() {
        return stk1.pop();
    }
    //As at every point of time the stack1 contains the first entered element on the top, we can just peek it.
    public int peek() {
        return stk1.peek();
    }
    //As at every point of time the stack1 contains all the elements that entered into the stack, checking just the stack1 is enough.
    public boolean empty() {
        return stk1.isEmpty();
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


 