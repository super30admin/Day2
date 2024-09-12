import java.util.Stack;

// Time Complexity : O(1) for Empty, Push and Peek, Worst Case for Pop is 2n. 
// Space Complexity : O(n) for Push, O(1) for Pop, Empty, and Peek.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt figure out at first that peek could be so easy.
//  My peek and pop were same at the first. I realized it, while I was going through previous class session
//  where we did an example of storing a value from the array which did not change.

// Your code here along with comments explaining your approach
class MyQueue {

    /** Stack to represent the queue */
    Stack<Integer> in;
    /** Stack to store the flipped input Stack */
    Stack<Integer> out;
    /** The firstelement of the stack. Usefull for the peek operation */
    private int firstElement;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        firstElement = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (in.empty())         //Checking if its the first element going in the queue
            firstElement = x;
        in.push(x);
    }

 /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        flip();                //Flips the stack by popping it to another stack
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!out.empty())      //If out stack contains any element, just peek it.
            return out.peek(); 
      return firstElement;     //If it is empty, it means no pop operation took place so we return the firstElement
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.empty() && in.empty();  
    }
    /**
     * This method flips the stack by popping from one stack to another.
     */
    public void flip() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }
}
