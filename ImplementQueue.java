// Time Complexity : best case - O(1) , worst case - O(N) - As pop(),peek() may take O(N) time
// Space Complexity : O(N) - N size of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
 /** Initialize your data structure here. */
 //Here used two stack data structures
 public MyQueue() {
     s1 = new Stack<Integer>();
     s2 = new Stack<Integer>();
 }
 
 /** Push element x to the back of queue. */
 //push() operation always occurs in O(1) time
 public void push(int x) {
     s1.push(x);
 }
 
 /** Removes the element from in front of queue and returns that element. */
 //pop() operation may happen in O(1) or O(N) time
 public int pop() {
     if(s2.isEmpty()){
         while(!s1.isEmpty()){
             s2.push(s1.pop());
         }
     }
      return s2.pop();
 }
 
 /** Get the front element. */
 //peek() operation may happen in O(1) or O(N) time
 public int peek() {
     if(s2.isEmpty()){
         while(!s1.isEmpty()){
             s2.push(s1.pop());
         }
     }
      return s2.peek();
 }
 
 /** Returns whether the queue is empty. */
 //Queue is only empty when both stacks are empty
 public boolean empty() {
     return s1.isEmpty() && s2.isEmpty();
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
// Your code here along with comments explaining your approach
