//Leetcode problem  - 232
// Time Complexity : push() : O(1)
//                   pop() : O(1) for avarage case, O(n) for worst case
//                   peek() : O(1) for avarage case, O(n) for worst case
//                   isEmpty() : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Was getting EmptyStackException intially on peek method as initially I didn't consider the case when stack would be empty


// Your code here along with comments explaining your approach

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1; //original stack 
    Stack<Integer> s2; //stack with reverse order of input being added
    int front = -1;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    /** element is popped from s2 as it contains the reverse order of input, hence the first element added
    can be retreived first. If s2 stack is empty, all the elements from the s1 stack are popped and pushed to 
    s2 stack (giving a reverse order of elements) and then the topmost element(first input added to s1) is popped from it.
    In case,s2 is not empty, the topmost element is popped as its the first element added at that point of time.
    */
    public int pop() {
      if(s2.isEmpty()){
          while(!s1.isEmpty()){
              s2.push(s1.pop());
          }
      }
        
      return s2.pop();  
    }
    
    /** Get the front element. */
    /** If s2 consists of elements(in reverse order), it just peeks the topmost element. In case s2 is empty, and s1 is not empty, all the elements from s1 are popped and pushed to s2. Then, the topmost element in s2 is peeked. In case s2 is empty and s1 is empty, it returns null.
    */
    public int peek() {
        if(!s2.isEmpty())
           return s2.peek();
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }



    /** Returns whether the queue is empty. */
    /** s1 stack is checked if its empty and returns false id there are elements in s1. There might be case where all elements from s1 are popped to s2, hence s2 is also checked. If s2 is also empty, that means there are no more elements in the queue(implemented as stack), returning true value for the function. In case s2 is still have some elements it will return false.
    */
    public boolean empty() {
        if(s1.isEmpty()){
            if(s2.isEmpty())
                return true;
            else
                return false;
        }
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
