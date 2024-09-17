import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
//Stack - LIFO
//Queue - FIFO
//Two stacks approach
//Stack 1 - enqueue - normal push
//Stack 1 - dequeue - pop all elements and push it to the Stack 2 then pop.
//Stack 1 - dequeue - 
//if stack2.empty 
//return stack2.pop();
//else if stack1.empty
//do same process of poping all elments to stack2.

public class StackQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    /** Initialize your data structure here. */
    public StackQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) {
            System.out.println("There is no element to dequeue");
            return -1;
        }
        if(!stack2.empty()) {
            return stack2.pop();
        }
        if(!stack1.empty()) {
            move1To2();
            return pop();
        } 
        return -1;
    }
    
     private void move1To2() {
         int size = stack1.size();
        for(int i =0;i<size;i++) {
            stack2.push(stack1.pop());
        }
    }
    
    /** Get the front element. */
    public int peek() {
         if(empty()) {
            System.out.println("There is no element in the queue");
            return -1;
        }
        if(!stack2.isEmpty()) {
            return stack2.peek();
        } 
        if(!stack1.isEmpty()) {
            return stack1.get(0);
        }
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.empty();
    }


    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        print(stackQueue);
        stackQueue.push(2);
        print(stackQueue);
        stackQueue.push(3);
        print(stackQueue);
        stackQueue.push(4);
        print(stackQueue);
        stackQueue.pop();
        print(stackQueue);
        stackQueue.push(5);
        print(stackQueue);
        stackQueue.pop();
        print(stackQueue);
        stackQueue.pop();
        print(stackQueue);
        stackQueue.pop();
        print(stackQueue);
        stackQueue.pop();
    }

    public static void print(StackQueue stackQueue) {
        System.out.println(stackQueue.peek());
    }
}


