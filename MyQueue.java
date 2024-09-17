// Time Complexity : push():O(1), pop():O(n), peek(): O(1), empty():O(1)
// Space Complexity : push():O(n), pop():O(1), peek(): O(1), empty():O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using two Stacks and implementing costly pop operation
import java.util.Stack;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int front;
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //To keep track of the front of queue in the order of insertion
        if(s1.isEmpty()){
            front = x;
        }
        //normally pushing the elements onto stack s1
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //if stack 2 is empty, we first empty s1 and put the elements in s2 so as to maintain the order of first in first out
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        //if s2 already contains s1 elements in FIFO order, just pop from s2
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //taking the top element from s2 if s2 is not empty as s2 maintains FIFO
        if(!s2.isEmpty()){
            return s2.peek();
        }
        //if s2 is empty, then the front element is stored as front variable when inserting to an empty s1.
        return front;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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


class Main { 
    public static void main(String args[]) 
    { 
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);  
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false 
    } 
}
