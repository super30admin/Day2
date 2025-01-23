import java.util.Stack;

//this is a different approach from the other queue implementation.

// Time Complexity : push - O(1) pop - Amortized O(1) peek - Amortized O(1) empty - O(1)
// Space Complexity : O(2*n) space complexity.
// Did this code successfully run on Leetcode : yes, I did run.
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
class Queue {
    /* I have used two stacks, one is for maintaining the elements, the other one is used when the pop operation apprears, 
    we transfer the elements from stack1 to stack2 and then pop the top element from stack2 which would be the first element that was entered */
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public Queue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    //when there is a push operation, just pushing into the stack1.
    public void push(int x) {
        // if(!stk1.isEmpty())
        // {
        //     while(!stk1.isEmpty())
        //     {
        //         stk2.push(stk1.peek());
        //         stk1.pop();
        //     }
                
        //     stk1.push(x);

        //     while(!stk2.isEmpty())
        //     {
        //         stk1.push(stk2.peek());
        //         stk2.pop();
        //     }
        // }
        // else
        stk1.push(x);
    }
    /*when its the pop or peek operation, we need to transfer the elements from stack1 to stack2 and then popped from the stack2,
    but we need to transfer only when the stack2 is empty, if it has elements then we no need to transfer, we can just directly pop it.*/
    public int pop() {
        if(stk2.isEmpty())
        {
            if(!stk1.isEmpty())
            {
                while(!stk1.isEmpty())
                {
                    stk2.push(stk1.peek());
                    stk1.pop();
                }
            }
        }
        
        return stk2.pop();
    }
    //same as pop.
    public int peek() {
        if(stk2.isEmpty())
        {
            if(!stk1.isEmpty())
            {
                while(!stk1.isEmpty())
                {
                    stk2.push(stk1.peek());
                    stk1.pop();
                }
            }
        }
        return stk2.peek();
    }
    //stack1 & stack2 needs to be checked because at any point there is a possibility that both contains the elements.
    public boolean empty() {
        if(stk1.isEmpty() && stk2.isEmpty())
            return true;
        else
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


 