
/**
 * Time Complexity: Amortize O(1) since once in a while we will run 
 * into a situation where we need to transfer all elements from in stack to out stack during peek/pop.
 * 
 * Space Complexity: O(n)
 * 
 * Did this code successfully run on Leetcode : Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

import java.util.Stack;

class MyQueue {

  Stack<Integer> in;
  Stack<Integer> out;

  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  public void push(int value) {
    in.push(value);
  }

  public int pop() {
    peek();
    return out.pop();
  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.peek();
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }

}
