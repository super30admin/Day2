// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : Run time error stating -java.lang.NullPointerException
  at line 14, MyQueue.push
  at line 63, __Driver__.__helperSelectMethod__
  at line 89, __Driver__.__helper__
  at line 110, __Driver__.main


// Your code here along with comments explaining your approach
import java.util.Stack;
class MyQueue {
    Stack<Integer> s1,s2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
        int front; 
    }
    //pusing the elements into stack s1 if s1 is empty
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
           s1.push(x);
    }
    //if s2 is empty then we need to push the elements to s2 untill s1 becomes empty is s2 is not empty then we need to pop the element from s2
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()){
       while(!s1.empty())
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    //if s2 is not empty then we need to return top element of s2 else we will take the last entered element in s1
    /** Get the front element. */
    public int peek() {
        if(!s2.empty()){
           return s2.peek();
       }
       return front;
        
        
    }
    // retruns true if s1 and s2 both are empty
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
