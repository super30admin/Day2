class MyQueue {
  /*

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No

  */

  Deque<Integer> stack1;
  Deque<Integer> stack2;
  
  public MyQueue() {
      stack1 = new ArrayDeque();
      stack2 = new ArrayDeque();
  }
  
  /*
    Time Complexity: O(1)
  
    Space Complexity: O(1)
  */
  public void push(int x) {
      stack1.push(x);
  }
  
  /*
    Time Complexity: O(1) (amortized)
  
    Space Complexity: O(1)
  */
  public int pop() {
      peek();
      
      return stack2.pop();
  }
  
  /*
    Time Complexity: O(1) (amortized)
  
    Space Complexity: O(1)
  */
  public int peek() {
      if(stack2.isEmpty()){
          while(!stack1.isEmpty()){
              stack2.push(stack1.pop());
          }
      }
      
      return stack2.peek();
  }
  
  public boolean empty() {
      return stack1.isEmpty() && stack2.isEmpty();
  }
}
