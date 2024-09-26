import java.util.*;
//pop is O(n), push is O(1);

class MyQueue {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public MyQueue() {

    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  public void push(int x) {
    stack1.push(x);

  }

  public int pop() {
    if (empty()) {
      return -1;
    }

    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public int peek() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  public boolean empty() {
    // since both stacks represent queue returns true only if commulative size== 0.
    return stack1.size() + stack2.size() == 0;
  }

  /**
   * Your MyQueue object will be instantiated and called as such:
   * MyQueue obj = new MyQueue();
   * obj.push(x);
   * int param_2 = obj.pop();
   * int param_3 = obj.peek();
   * boolean param_4 = obj.empty();
   */

  public static void main(String[] args) {
    /* Start with the empty list. */
    MyQueue queue = new MyQueue();

    queue.push(1);

    queue.push(2);

    queue.peek(); // returns 1
    System.out.println(queue.peek());

    queue.pop(); // returns 1
    System.out.println(queue.pop());

    queue.empty(); // returns false
    System.out.println(queue.empty());
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