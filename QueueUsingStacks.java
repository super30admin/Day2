// Time Complexity : push, peek, empty - O(1), pop - O(N)
// Space Complexity : O(N+M) - N for enqueue stack and M for dequeue stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
// Maintain 2 stacks - enqueue and dequeue
// add elements to enqueue stack when push is called
// while popping check if deque stcack if empty and move all ements from enqueue stack to dequeue stack and then pop
// also maintain a firstElement to keep a track of the element to peeked.
import java.util.*;
class MyQueue {
    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack2;
    int firstElement;
    /** Initialize your data structure here. */
    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(enqueueStack.isEmpty())
            firstElement = x;
        
        enqueueStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(dequeueStack2.isEmpty()) {
            while(!enqueueStack.isEmpty()) {
                dequeueStack2.push(enqueueStack.pop());
            }
        }
        return dequeueStack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!dequeueStack2.isEmpty()) {
            return dequeueStack2.peek();
        }
        
        return firstElement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack2.isEmpty();
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