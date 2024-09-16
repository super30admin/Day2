import java.util.Stack;

// Time Complexity : push: O(1), pop: O(1), peek: O(1) Amortized  
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/* 
1. We are maintaining an in Stack and an out  stack 
2. We keep pushing the elements the elements in the in stack until a pop happens
3. now, we have all elements arranged in FIFO manner in out queue
4. so we can pop until the out stack becomes empty that will give us top of a queue
5. meanwhile we can keep pushing elements in the in stack
6. if the out queue is empty we need to again transfer all the elements

*/


public class MyQueue {
Stack<Integer> in;
Stack<Integer> out;

public MyQueue() {
    in=new Stack<>();
    out=new Stack<>();
}

/** Push element x to the back of queue. */
public void push(int x) {
    in.push(x);
}

/** Removes the element from in front of queue and returns that element. */
public int pop() {
    
   
    int topElement=peek();
    out.pop();
    
    return topElement;
    
}

/** Get the front element. */
public int peek() {
   
    
    if(out.isEmpty())
    {
        while(!in.isEmpty())
            out.push(in.pop());
    }
    return out.peek();
        
}

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

public static void main(String[] args)
{
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.peek());
    System.out.println(queue.pop());
    System.out.println(queue.empty());
}
    
}
