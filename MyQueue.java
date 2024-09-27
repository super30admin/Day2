/**
   Implementing a queue with 2 stacks. One stack handles the push and other stack handles the pop
 * Time Complexity for put: O(1);
 * Time Complexity for remove: O(1);
 * Space Complexity: O(n);
 * Successfully ran and submitted on LeetCode;
 */

class MyQueue {

    Stack<Integer> S1;
    Stack<Integer> S2;
    
    /** data structure Initialization */
    public MyQueue() {
        S1 = new Stack<Integer>();
        S2 = new Stack<Integer>();
    }
    
    /** Push element x to the S1 stack */
    public void push(int x) {      
        S1.push(x);        
    }
    
    /** Removes the ele from s1 and pushes the ele in S2 stack. Returns removed element from S2 */
    public int pop() {
        if(S2.size() == 0) 
        {
            while(S1.size() > 0) 
            {
                int x = S1.pop();
                S2.push(x);
            }
            
        } 
        return S2.pop();
    }
    
    /** Returns front element from S2 */
    public int peek() {
        if(S2.size() == 0) 
        {
            while(S1.size() > 0) 
            {
                int x = S1.pop();
                S2.push(x);
                
            }          
        }
        return S2.peek();
    }
    
    /** Checking if S1 and S2 are empty */
    public boolean empty() {
        if(S2.isEmpty() && S1.isEmpty()) 
        {
            return true;
        }
        return false;
    }
}
