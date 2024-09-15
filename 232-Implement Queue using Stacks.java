
//Time Complexity=O(1)
//Space Complexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {//Initiallizing two stacks
        in=new Stack<>();
        out=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();//We are calling the peek function and then poping the 1st element of out stack
        return out.pop();
    }
    
    //During peek operation we are intially checking whether the out stack is empty if it is then we are firstly moving all elements in out list and then returning the top most value in out stack
    
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
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */