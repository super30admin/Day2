import java.util.*;
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s2.isEmpty())
        {
            s2.push(x);
        }
        else
        {
            while(!s2.isEmpty())
            {
                int temp = s2.pop();
                s1.push(temp);
            }
            s1.push(x);
            while(!s1.isEmpty())
            {
                int temp = s1.pop();
                s2.push(temp);
            }
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s2.isEmpty())
            return true;
        return false;
    }
    public static void main(String args[])
    {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);  
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty(); // returns false
    }

}


