// Time Complexity : 
    // push(int x) -> O(1);
    //pop() = O(1);
// Space Complexity : O(n); 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class MyQueue {
 
 // one stack to store push elements
    Stack<Integer> s1;
// second stack to store elements when pop/peek operations are performed sinnce queue is fifo and stack is lifo
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    int temp;
    /** Push element x to the back of queue. */
    public void push(int x) {
        // if s1 is empty, then the top most element will be the first element pushed
        if(s1.empty()){
            temp =x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // transfer all the elements from s1 to s2 to perform pop operation because we 
        // need the first element pushed 
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
            s2.push(s1.pop());
            }
        }
        return s2.pop();
}
    
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return temp;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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