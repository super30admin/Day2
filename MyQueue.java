package s30.precourse.Problems;
import java.util.*;

// time complexity - push () -> O(n); pop() -> O(1); peek -> O(1)
// Space complexity - O(n)

public class MyQueue {

    // creating the Stacks
    Stack <Integer> in; 
    Stack<Integer> out;

    public MyQueue() {
        
        in = new Stack <> ();
        out = new Stack <> ();
        
    }
    
    // pushing the elements into the queue
    public void push(int x) {
        
        in.push(x);
        
    }
    
    // popping out the elements from the queue
    public int pop() {
        
        peek();
        return out.pop();
        
    }
    
    // peeking an element from the queue
    public int peek() {
        
        if (out.isEmpty()) {
            
            while (in.isEmpty () == false) {
                
                out.push(in.pop());
                
            }
             
        }
        
        return out.peek();
        
    }
    
    // checking if the queue is empty or not
    public boolean empty() {
        
        return in.isEmpty() && out.isEmpty();
        
    }

    public static void main (String [] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false

    }
    
}
