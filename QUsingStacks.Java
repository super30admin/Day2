// Time Complexity : Amortized O(1) for pop and peek. O(1) for isEmpty and push operations.
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we will be using 2 stacks -- we push every element directly to the first stack but when there is
// pop operation transfer all the elements from 1st stack to 2nd stack (provided if the 2nd stack is empty).
// follow the same pop process for peek opeation and return the top element.


class MyQueue {

  Stack<Integer>in;
  Stack<Integer>out;

  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    if(!out.isEmpty()) {
      return out.pop();
    }
    while(!in.isEmpty()) {
      int val = in.pop();
      out.push(val);
    }
    return out.pop();
  }

  public int peek() {
    if(!out.isEmpty()) {
      return out.peek();
    }
    while(!in.isEmpty()) {
      int val = in.pop();
      out.push(val);
    }
    return out.peek();
  }

  public boolean empty() {
    if(in.isEmpty() && out.isEmpty()) {
      return true;
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