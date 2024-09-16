// Time Complexity : 1ms (faster than 74.67% online submissions) 
// Space Complexity : 42 MB (less than 37.69% submissions)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I made 2 stack - stack1, stack2

// PUSH - I pushed all the elements in stack1 [straight forwards.. lol]
// POP - For pop, first I checked if stack2 is empty, then I poped all the elements
// of stack1 putting them simultaneously in stack2 so that the order reverses.
// Then I poped an element from stack2.
// If, stack2 already had elements, then the upper ^ action will not take place and
// user will get data as stack2 popped element (as there is already stuff in stack2 as first in first out bases).
// PEEK - used the steps as in pop method but just did stack2.peek for the PEEK function
// empty - checked if stack1 and stack2 are empty.. if yes, then returned true else.. returned false


class MyQueue {

    
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    public MyQueue() {
          
    }
    
    public void push(int x) {
        stack1.push(x);
    
    }
    
    public int pop() {
        int var = 0;
        
        if (stack2.empty()){
          while (!stack1.empty()){
            var = stack1.pop();
            stack2.push(var);
            }  
        }
        
        int abc = stack2.pop();
        return abc;
    }
    
    public int peek() {
        int var = 0;       
        if (stack2.empty()){
          while (!stack1.empty()){
            var = stack1.pop();
            stack2.push(var);
            }  
        }
        int abc = stack2.peek();
        return abc;
    }
    
    public boolean empty() {
        if (stack1.empty() && stack2.empty()){
            return true;
        }
        return false;
    }
}


  