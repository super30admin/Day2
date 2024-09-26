// Time Complexity :
//      push = O(1)
//      pop = O(n)
//      top = O(n)
//      empty = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Suggestion: Please suggest how to optimize the code for pop and top methods


class MyQueue {
    
    // private Stack primaryStack;
    // private Stack secondaryStack;
    Stack<Integer> primaryStack; 
    Stack<Integer> secondaryStack; 

    public MyQueue() {
        
        primaryStack = new Stack<Integer>();
        secondaryStack = new Stack<Integer>();
          
    }
    
    public void push(int x) {
        primaryStack.push(x); 
    }
    
    public int pop() {
        while(!primaryStack.isEmpty()) {
            secondaryStack.push(primaryStack.pop());
        }
        
        int popElement = secondaryStack.pop();
        
        while(!secondaryStack.isEmpty()) {
            primaryStack.push(secondaryStack.pop());
        }
        return popElement;
        
    }
    
    public int peek() {
        while(!primaryStack.isEmpty()) {
            secondaryStack.push(primaryStack.pop());
        }
        
        int peekElement = secondaryStack.peek();
        while(!secondaryStack.isEmpty()) {
            primaryStack.push(secondaryStack.pop());
        }
        return peekElement;
        
    }
    
    public boolean empty() {
        return primaryStack.isEmpty();
        
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

