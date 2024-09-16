// Time Complexity : avg : O(1) , worst : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack();
        out= new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    //Complexity : worst case O(n), avg/amortized: O(1)
    public int pop() {
        // do this only when out stack is empty so we are not pushing elemnts evrytime thats why avg time   complexity is O(1)
        if(out.isEmpty())
        {       // push all the elements from stack 1 to second stack, reverses elemnts and maintains FIFO
                while(!in.isEmpty())
                {
                    out.push(in.pop());
                }
        }
       return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        // do this only when out stack is empty
         if(out.isEmpty())
        {    
                while(!in.isEmpty())
                {
                    out.push(in.pop());
                }
        }
       return out.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
