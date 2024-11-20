// Time Complexity : enqueue takes O(n) time and dequeue takes O(1) time
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes (https://leetcode.com/submissions/detail/567556602/)
// Any problem you faced while coding this :

import java.util.Stack;

public class MyQueue {

    Stack<Integer> tempStack;
    Stack<Integer> queueStack;

    public MyQueue() {
        tempStack = new Stack();
        queueStack = new Stack();
    }

    // In queueStack, the oldest element will be at top
    public void push(int x) {
        if (queueStack.empty()) {
            queueStack.push(x);
        } else {
            while (!queueStack.empty()) {
                int poppedElement = queueStack.pop();
                tempStack.push(poppedElement);
            }
            queueStack.push(x);
            while (!tempStack.empty()) {
                int poppedElement = tempStack.pop();
                queueStack.push(poppedElement);
            }
        }
    }

    public int pop() {
        int result = queueStack.pop();
        return result;
    }

    public int peek() {
        int result = queueStack.peek();
        return result;
    }

    public boolean empty() {
        if (queueStack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
