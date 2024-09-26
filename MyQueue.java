//time complexity : Best case scenario push O(1), pop O(1), peek O(1), empty O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    
    //maintain 2stacks
    //use stack 2 while popping
    private Stack<Integer> s1; 
    private Stack<Integer> s2; // s2 alwayas maintains FIFO order

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        // always push into s1
        s1.push(x);
    }
    
    private void transfer(){
        // transfer items from s1 to s2
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    public int pop() {
        // always pop from s2 stack

        if(empty()) {
            return -1;
        }
        
        //if s2 is empty then transfer items from s1
        if(s2.isEmpty()) {
            transfer();
        }
        
        //return top of s2
        return s2.pop();
    }
    
    public int peek() {

        //always peek from s2 stack

        //if s2 is empty then transfer items from s1
        if(s2.isEmpty()) {
            transfer();
        }
        return s2.peek();
    }
    
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
