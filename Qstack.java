// Time Complexity : 
// push - O(1)
// pop - O(n)
// peek - O(n)
// empty - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but need help with optimising the solution mainly pop,peek methods and also the space
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        s1.push(x);
     
    }
    
    public int pop() {
       while(!s1.empty()){
            s2.push(s1.pop());
        }
        int res=s2.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return res;
    }
    
    public int peek() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int res=s2.peek();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return s1.isEmpty();
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