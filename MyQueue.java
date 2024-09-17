import java.util.*;

// Time Complexity : O(n) for push and O(1) for the rest of functions
// Space Complexity : O(2n)=O(n) for size of 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyQueue {

    private int front;
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        if(stack1.empty()){
            front = x;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        int pop = stack1.pop();
        if(!stack1.empty()){
            front = stack1.peek();
        }

        return pop;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
