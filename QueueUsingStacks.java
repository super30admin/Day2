// Time Complexity : O(1)-push , o(1)- pop,peek-ammotized time comp
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding optimized solution was little challenging, but now am good with this


class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    
    /** Initialize your data structure here. */
    public MyQueue() {
     in =new Stack<Integer>();//used for push operation
     out =new Stack<Integer>();//used for pop operation   
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) { // o(1);
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {//o(1)-ammotized time complexity-
        if(out.isEmpty())
        {
            while(!in.isEmpty())//o(n)- called sometimes
            {
                int ele = in.pop();
                out.push(ele);
            }
           
        }
        return out.pop(); //o(1) - called always
    }
    
    /** Get the front element. */
    public int peek() {//o(1)-ammotized
        if(out.isEmpty())
        {
            while(!in.isEmpty())//o(n)- called sometimes
            {
                int ele = in.pop();
                out.push(ele);
            }
           
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty() )
        {
            return true;
        }
        else
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