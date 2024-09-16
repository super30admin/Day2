class MyQueue {

  Stack<Integer> mStack;
  Stack<Integer> aStack;
  
  /** Initialize your data structure here. */
  public MyQueue() {
      this.mStack = new Stack<>();
      this.aStack = new Stack<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      if(mStack.isEmpty()) {
          mStack.push(x);
      } else {
          while(!mStack.isEmpty()) {
              aStack.push(mStack.pop());
          }
          
          mStack.push(x);
          
          while(!aStack.isEmpty()) {
              mStack.push(aStack.pop());
          }
      }
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      return mStack.pop();
  }
  
  /** Get the front element. */
  public int peek() {
      return mStack.peek();
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return mStack.isEmpty();   
  }
}


// Three Line Algo Explanation
/* -> In this approach we are using two stacks, whenever a new element is pushed on the stack we populate the auxillary stack by popping elements from main stack
and then when new element is pushed on to the main stack, we move elements from aux stack to main stack, thus getting a Queue like structure. Rest all operations 
are mirrioring regular stack operation */

// Time and Space Complexity Analysis
// Time Complexity: Push -> O(n), rest all others operations: O(1)
// Space Complexity: Push -> O(n), rest of the operations: O(1)
