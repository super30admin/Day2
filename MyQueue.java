/*
Time Complexity:
PUSH : O(1)
POP : O(1) average case but in worst case O(n)
Peek : O(1)

Space Complexity :

    Used two Stack each hold N input size:
    that's why space complexty is O(N)
    
Tested in Leetcode Successfully : YES
Challenges face : It was easy no trouble

*/

import java.util.Deque;
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> stack1;
    int front ;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
        front = Integer.MAX_VALUE;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()){
            front = x;
        }
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
            if(stack1.isEmpty()){
                while(!stack.isEmpty()){
                    stack1.push(stack.pop());
                }    
            }
            int remove = stack1.pop();
            return remove;
        
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack1.isEmpty()){
            return stack1.peek();
        }
        else{
            return front;
        }
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stack1.isEmpty();
    }



    public static void main(String[] args) {
            
        //  Your MyQueue object will be instantiated and called as such:
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    // queue.push(4);
    System.out.println(queue.pop());
    queue.push(3);
    queue.push(4);
    System.out.println(queue.pop());
    System.out.println(queue.peek());
    
    System.out.println();
    // while(!queue.empty()){
    //     System.out.println(queue.pop());
    // }
    
    
    }
}
