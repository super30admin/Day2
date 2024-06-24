// Time Complexity : push(), empty() - O(1), pop(), peek() - best and average case - O(1), worst case - O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

  Stack<Integer> s1;

  Stack<Integer> s2;

  // Constructor
  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  // Push into first stack.
  public void push(int x) {
    s1.push(x);
  }

  // Perform peek then pop from second stack.
  public int pop() {
    peek();
    return s2.pop();
  }

  // Peek from second stack, if stack is empty, transfer all elements from first to second stack.
  public int peek() {
    if(s2.isEmpty()) {
      while(!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }

  // Check if queue is empty.
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