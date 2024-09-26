// Time Complexity : Push - O(1) || Pop - If outStack is empty: O(n) and if outStack is not empty: O(1) || Peek - Same Analogy as Pop (If OutStack empty: O(n), if not empty outStack: O(1)) || Empty - O(1)
// Space Complexity : 1 stack of size n to store pushed elements and 1 stack of size n to store outgoing elements - so total O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.Stack;
class MyQueue { //Initialize two stacks - one for incoming elements and one for outgoing.
        Stack <Integer> inStack = new Stack<>();
        Stack <Integer> outStack = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() { //Removing garbage values if any by emptying both stacks initially.
        inStack.clear();
        outStack.clear();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) { // Simply push the element in the inStack stack for any incoming element
                              //Incoming Elements should only be pushed in the inStack 
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() { //Pop must be done only in the outStack stack
                       //Check if outStack is empty before popping. If it is empty, then pop all elements from inStack and push into OutStack before popping from outStack.
        if(outStack.isEmpty())
        {
            while(!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
        
    }
    
    
    /** Get the front element. */
    public int peek() { //Similar check condition as Pop. Except, peek instead of Popping in the OutStack
                        //Peek should always retrieve top of the OutStack as the result.
        if(outStack.isEmpty())
        {
            while(!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() { //Check if both are empty, only then return true else return false
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    MyQueue obj = new MyQueue();
    obj.push(30);
    obj.push(40);
    obj.push(5);
    obj.push(-2);
    obj.push(-1);
    obj.pop();
    obj.push(6);
    int param_3 = obj.pop();
    int param_4 = obj.peek();
    boolean param_5 = obj.empty();
    System.out.println("Popping from the Queue - " + param_3);
    System.out.println("Front of the queue - " + param_4);
    System.out.println("Is the stack empty (True or False) - " + param_5);
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