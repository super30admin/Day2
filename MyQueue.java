// Time Complexity : amortized O(1)
// Space Complexity : 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
//Memory Usage: 36.7 MB, less than 73.39% of Java online submissions for Implement Queue using Stacks.
// Any problem you faced while coding this : No

class MyQueue {

  /** Initialize your data structure here. */
  Stack < Integer > stack1;
  Stack < Integer > stack2;
  public MyQueue() {
    stack1 = new Stack < Integer > ();
    stack2 = new Stack < Integer > ();

  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stack1.push(x);

  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
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
