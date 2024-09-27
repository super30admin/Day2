import java.util.Stack;

/*******
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

Time Complexity :   O (1) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (232. Implement Queue using Stacks)
Any problem you faced while coding this :       No
*******/

class MyQueue {
    private Stack<Integer> input;     
    private Stack<Integer> output;    

    public MyQueue() {
        input = new Stack<Integer>();   // input stack used for pushing
        output = new Stack<Integer>();  // output stack used for pop / peek
    }
    
    // push the element in input stack
    public void push(int x) {   // O (1)
        input.push(x);
        System.out.println("Added "+ x + " into Queue");
    }
    
    // pop the elements from output stack, 
    // if output stack is empty, copy all the elements from input stack
    public int pop() {          // O (1)
        if (output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    // peek the elements from output stack, 
    // if output stack is empty, copy all the elements from input stack
    public int peek() {          // O (1)
        if (output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    // return true if both the stacks are empty
    public boolean empty() {
        return ( input.isEmpty() && output.isEmpty());
    }

    public static void main(String args[]) 
    { 
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println("Removed "+ obj.pop() + " from Queue");
        System.out.println("Peek value: "+ obj.peek() + " from Queue");
        System.out.println("Queue Empty: "+ obj.empty() + " from Queue");
    }
}
