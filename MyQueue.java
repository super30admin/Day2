/*
Approach = using 2 stacks here, the in and out stack.
we will always push to the in stack, for pop and peek we will pop from the out stack
Will move everything from in stack to out stack when the out stack is empty

push - TC - O(1) and SC - O(n)
pop - TC - O(1) and SC - O(1)
peek - TC - O(1) and SC - O(1)
empty - TC - O(1) and SC - O(1)
 */

/**
 *  MyQueue : MyQueue
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 23, 2024)
 * @since : 1.0 (Oct 23, 2024)
 *
 */

import java.util.*;

class MyQueue {
 Stack<Integer> in;
 Stack<Integer> out;
 public MyQueue() {
  in = new Stack<>();
  out = new Stack<>();
 }
 
 public void push(int x) {
  in.push(x);
 }
 
 public int pop() {
  if(out.isEmpty()){
   while(!in.isEmpty()){
    out.push(in.pop());
   }
  }
  return out.pop();
 }
 
 public int peek() {
  if(out.isEmpty()){
   while(!in.isEmpty()){
    out.push(in.pop());
   }
  }
  return out.peek();
 }
 
 public boolean empty() {
  return in.isEmpty() && out.isEmpty();
 }
 
 public static void main(String[] args) {
  MyQueue myQueue = new MyQueue();
  myQueue.push(1);
  myQueue.push(2);
  System.out.println(myQueue.pop());
  System.out.println(myQueue.peek());
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