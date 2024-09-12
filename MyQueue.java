
//Problem 1: Implement Queue using stack

// Time Complexity : Each Operation would take around O(n) as to remove or add element at particular index we have traverse the whole stack
// Space Complexity : Size of the stack which is O(n) - n is the number of elements to be pushed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer for particular stack method to achive this.

import java.util.Stack;
class MyQueue {
  int top = -1;
  Stack<Integer> s;
  /** Initialize your data structure here. */
  public MyQueue() {
    s = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    top++;
    s.add(top, x);

  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(!empty()){
      int ele = s.get(0);
      s.remove(0);
      top--;
      return ele;
    }
    return -1;
  }

  /** Get the front element. */
  public int peek() {
    if(!empty()){
      int ele = s.get(0);
      return ele;
    }
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s.isEmpty() ? true : false;
  }

  public static void main(String[] args){
    MyQueue obj = new MyQueue();
    obj.push(x);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
  }
}
