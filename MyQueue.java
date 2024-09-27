// Time Complexity: O(1)
// Space Complexity: O(1)
class MyQueue {

    //We will create two stacks
    Stack<Integer> in;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //We will push the elements in the in stack.
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //We will call the peek function
        peek();
        //then we will pop from out stack as we have transferred from in stack to out stack when there was a pop operation.
        //Queue is FIFO, means now in the out stack we have pushed elements in FIFO.
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       //When there is a pop operation, we will check whether the out stack is empty is or not.
        if(out.isEmpty()) {
            //then pop the value from in stack and push it to out stack until the in stack is empty.
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //To check whether queue is empty is empty or not, both the stacks need to be empty.
        return in.isEmpty() && out.isEmpty();
    }
}