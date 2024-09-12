class MyQueue {

    Stack<Integer> in = null;
    Stack<Integer> out = null;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<Integer>();
        out= new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty())
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(out.isEmpty() && in.isEmpty())
        {
            return true;
        }
        return false;
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

//time complexity : O(1)
//space Complexity : O(n)
//Not faced any issues while implementing
//Approach : 2 stack-- push until pop operation comes in and when pop comes than we can one by one push to another array and fetch the first element.
//ran succesfully on leetcode
