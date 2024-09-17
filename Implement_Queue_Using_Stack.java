import java.util.Stack;

public class Implement_Queue_Using_Stack {
	//Approach: 1. Am having 2 stacks here, while push, I take out all elements from stack1 and push in stack2. 
	//Then push element onto stack1 and again pop all from stack2 to push in stack1. Because, this maintains a queue like structure in stack1.
	//2. But for pop, i will just pop element from stack1 with O(1)
	//3. For peek and isEmpty, i can check on stack1.
	Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public Implement_Queue_Using_Stack() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = 0;
        if(!stack1.isEmpty())
            val = stack1.pop();
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
    public static void main(String args[])
    {
    	Implement_Queue_Using_Stack obj = new Implement_Queue_Using_Stack();
    	 obj.push(3);
    	 int param_2 = obj.pop();
    	 int param_3 = obj.peek();
    	 boolean param_4 = obj.empty();
    }
}
//Time Complexity : O(n) for push, for pop its O(1) and for isEmpty() and peek its O(1).
//Space Complexity : O(n), where n is the number of elements in the Hash Map, since we will be creating those many number of Linked list nodes 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

