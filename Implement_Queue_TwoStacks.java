import java.util.*;
class MyQueue {

    /** Initialize your data structure here. */
    // Time Amortized O(1)
    // Space Amortized O(1)
    Stack<Integer> Main_Stack;
    Stack<Integer> Temp;
    public MyQueue() {
      Main_Stack = new Stack<>();
      Temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Main_Stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(Temp.isEmpty())
        {
            while(!Main_Stack.isEmpty())
            {
                Temp.push(Main_Stack.pop());
            }
        }
        return Temp.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if(Temp.isEmpty())
        {
            while(!Main_Stack.isEmpty())
            {
                Temp.push(Main_Stack.pop());
            }
        }
        return Temp.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return Main_Stack.isEmpty() && Temp.isEmpty();
    }

    public static void main(String args[])
    {
        MyQueue Q = new MyQueue();
        Q.push(1);Q.push(2);Q.push(3);
        System.out.println("popped "+Q.pop());
        System.out.println("peek "+Q.peek());
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