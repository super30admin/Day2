//Time Complexity: O(1)
//Space Complexity: O(n)
//running on leetcode: yes
class MyQueue {

    /** Initialize your data structure here. */
    //two stacks initialized here
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>(); //in stack (LIFO)
        out = new Stack<>(); //out stack (FIFO)
    }
    
    /** Push element x to the back of queue. */
    //O(1)
    public void push(int x) {
        //push any new value into the in stack
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    //O(1)
    public int pop() {
        //also consider if stack 1 has only one element
        //peek method returns the top element from the queue, and ensures pop is not done on an empty stack
        peek();
        return out.pop();  
    }
    
    /** Get the front element. */
    //O(1)
    public int peek() {
        //check if out is empty
        if (out.isEmpty())
        {
            while (!in.isEmpty())
            {
                //pop elements from in stack and push them into out stack
                out.push(in.pop());
            }
        }
        //out is not empty, just return top element from out stack
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    //O(1)
    public boolean empty() {
        return in.empty() && out.isEmpty();
    }
}
