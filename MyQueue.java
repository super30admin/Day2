import java.util.Stack;

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class MyQueue {

    Stack<Integer> queue = new Stack<Integer>();

    public MyQueue() {

    }

     // Time Complexity :  O(N)
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!queue.empty()) {
            temp.push(queue.pop());
        }
        queue.push(x);
        while (!temp.empty()) {
            queue.push(temp.pop());
        }
    }

     // Time Complexity : O(1)
    public int pop() {
        return queue.pop();
    }

     // Time Complexity : O(1)
    public int peek() {
        return queue.peek();
    }

     // Time Complexity : O(1)
    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */