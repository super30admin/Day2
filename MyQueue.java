// Time Complexity : O(1) for push, pop,peek empty, however few times it can take more time for pop and peek
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create 2 stacks, always push in 1st one
//When we pop if stack2 is empty tranfer all the contents of stack1 to stack2 and then do pop
//Always do pop and peek from stack2

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(!st2.isEmpty()){
            return st2.pop();
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
      
        return st2.pop();
    }
    
    public int peek() {
        if(!st2.isEmpty()){
            return st2.peek();
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        if(st1.isEmpty() && st2.isEmpty())
            return true;
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