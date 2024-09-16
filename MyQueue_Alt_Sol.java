class MyQueue {

  private int front;
  Stack<Integer> mStack;
  Stack<Integer> aStack;
  
  
  
  /** Initialize your data structure here. */
  public MyQueue() {
      mStack = new Stack<>();
      aStack = new Stack<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      if (mStack.isEmpty()) {
          front = x;
      }
      mStack.push(x);
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      if (!aStack.isEmpty()){
          return aStack.pop();
      } else {
          while(!mStack.isEmpty()) {
              aStack.push(mStack.pop());
          }
      }
          
      return aStack.pop();
  }
  
  /** Get the front element. */
  public int peek() {
      if(!aStack.isEmpty()) {
          return aStack.peek();
      } 
      return front;
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return mStack.isEmpty() && aStack.isEmpty();
  }
}

/* This is Also a Two Stack Approach but here, we use "Front" to store the first element of queue, when we need to pop and element from Queue, we use the second stack 
to reverse the first stack and pop fron there untill it is empty. All push operations are perfromed on first stack. */

// Time and Space Complexity Analysis
// Time Complexity: All Operations -> O(1), Pop -> O(n) [Worst Case]
// Space Complexity: Push -> O(n) [For Queue Elements], Other operations -> O(1)
