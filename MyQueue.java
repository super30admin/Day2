//Time Complexity: push--> O(1)
//pop --> O(1)

//Space Complexitiy O(N) when N is the number of elements.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//I used two stacks for this approach(fstack and sstack).
//When there is a push operation I pushed the elements directly into fstack.
//sstack is maintained to perform pop operation on the queue. 
//When I have to perform a pop from queue and sstack is empty all the elements in 
//fstack are pushed to sstack and then elements are popped from the sstack.


import java.util.*;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> fstack = new Stack<Integer>();
    Stack<Integer> sstack = new Stack<Integer>();
    
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        fstack.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!sstack.isEmpty())
            return sstack.pop();
        else{
        while(!fstack.isEmpty()){
            sstack.push(fstack.pop());
        }
        return sstack.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!sstack.isEmpty())
            return sstack.peek();
        else{
        while(!fstack.isEmpty()){
            sstack.push(fstack.pop());
        }
        return sstack.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
       if(fstack.isEmpty() && sstack.isEmpty())
           return true;
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