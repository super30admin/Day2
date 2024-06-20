import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(1) amortized
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
In implementing two stacks, I used the first stack to always push the values. In the second stack,
I only push by popping the top value of the first stack until its empty (only when pop is called
on first stack). For pop, I simply pop the top element from second stack. Same for peek. Only if both
of the stacks are empty at any point, I will return it as true.
This solution had 0ms in TC and beat 100% on LeetCode, so kindly check and explain how was this possible
 */

public class MyQueue {
    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.empty() && inStack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        int peek1 = myQueue.peek();
        int pop1 = myQueue.pop();
        int peek2 = myQueue.peek();
        boolean empty1 = myQueue.empty();
        System.out.println(peek1 + " is top \n" +
                pop1 + " is popped \n" + peek2 + " is top \n" + empty1);
    }
}
