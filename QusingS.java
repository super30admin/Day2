// Time Complexity : push O(n), pop O(1),peek O(1),empty O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


import java.util.*;
public class QusingS {

    
    static class MyQueue {
        
        Deque<Integer> stackOldestOnTop;
        Deque<Integer> stack;
        public char[] push;
        
        public MyQueue() {
            stackOldestOnTop = new ArrayDeque<Integer>(); // used for keeping elements of queue in proper order
            stack = new ArrayDeque<Integer>();              // used for push operation
        }
        
        public void push(int x) { 
        while(!stackOldestOnTop.isEmpty()){  //This ensures that stackOldestOnTop is empty so the new element can be added at the correct position
            stack.push(stackOldestOnTop.pop()); 
        }
        stackOldestOnTop.push(x);  //used for pushing the new element onto it
        while(!stack.isEmpty()){
            stackOldestOnTop.push(stack.pop());  // used for restoring the order with the new element at the end
        }
        
    }
    
    public int pop() {
        return stackOldestOnTop.pop();
    }
    
    public int peek() {
        return stackOldestOnTop.peek();
    }
    
    public boolean empty() {
        return stackOldestOnTop.isEmpty();
    }
}
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(51);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();

        System.out.println(param_3);
        System.out.println(param_2);
        System.out.println(param_4);
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

// Your code here along with comments explaining your approach
