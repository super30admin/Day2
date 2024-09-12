/**
 * Time Complexity: 
 * push(), empty() : O(1)
 * pop(), peek() : O(n) where n = number of elements in 'in' Stack
 * Approach used : 2 stacks 
 */

import java.util.Stack;

class MyQueue {

    Stack<Integer> in,out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty()){
            System.out.println("Empty queue, cannot peek. Returning -1");
            return -1;
        }
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

public static void main(String args[]){
    MyQueue obj = new MyQueue();
    int x = 10;
    obj.push(x);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
    System.out.println("pop: "+param_2);
    System.out.println("peek: "+param_3);
    System.out.println("empty: "+param_4);
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