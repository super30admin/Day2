import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MyQueue {
    // Create two stacks   
      Stack<Integer> s1;
      Stack<Integer> s2;
      
      public MyQueue() {
      // Initailize Stacks
          s1=new Stack<>();
          s2=new Stack<>();
      }
      
      public void push(int x) {
  
      // pop all elements from s1 and then store them to s2,
  
          while(!s1.isEmpty()){
              s2.push(s1.pop());
          }
              // Use S1 to store element that you want to add to queue.
          s1.push(x);
          // push back all the elements from s2 till s2 is not empty
          while(!s2.isEmpty()){
              s1.push(s2.pop());
          }
      }
      
      public int pop() {
      // As top of s1 is top of the queue , pop top of s1
          return s1.pop();
          
      }
      
      public int peek() {
          return s1.peek();
      }
      
      public boolean empty() {
          return s1.isEmpty();
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
