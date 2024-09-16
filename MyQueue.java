// Time Complexity : O(1) for every operation-> push,pop,peek,empty
// Space Complexity :O(n) for primary stack and O(n) for secondary stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    /** Initialize your data structure here. */
    
    Stack<Integer> pristack;  // use primary stack
    Stack<Integer> secstack;  // use secondary stack
    int top;
    public MyQueue() {
        
        pristack = new Stack<Integer>();  // assign both stacks
        secstack= new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        if(pristack.isEmpty())  // check if primary stack is empty
            top=x;             // make the  top element to x so that peek                               //function always returns a valid value if                               //secstack is empty
        
        pristack.push(x);    //  push every insert to primary stack
                     
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(secstack.isEmpty()){   // keep popping elements from primary 
       while(!pristack.isEmpty()){    // stack into secondary stack until
        secstack.push(pristack.pop()); // primary stack is empty
        }
       }
        int el=secstack.pop();   // pop the top most element from secondary stack                                         // secstack as it is now good as queue
        return el;
        
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(!secstack.isEmpty()){ // check if secondary stack is not empty
        return secstack.peek(); // return topmost element of secstack
        }
        return top;  // if empty get the first insert into primary stack
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return secstack.isEmpty() && pristack.isEmpty(); // check if both stacks are empty
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