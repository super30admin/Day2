// Time Complexity : Average - O(1), Worst - O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(!st2.isEmpty()) return st2.pop();
        else {
            while(!st1.empty()) {
                st2.push(st1.pop());
            }
            return st2.pop();
        }
    }
    
    public int peek() {
       if(!st2.isEmpty()) return st2.peek();
        else {
            while(!st1.empty()) {
                st2.push(st1.pop());
            }
            return st2.peek();
        }
    }
    
    public boolean empty() {
        return st1.size() == 0 && st2.size() == 0;
    }
}
/**
class MyQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        while(!st1.empty()) {
            st2.push(st1.pop());
        }
        int ele = st2.pop();
        while(!st2.empty()) {
            st1.push(st2.pop());
        }
        return ele;
    }
    
    public int peek() {
        while(!st1.empty()) {
            st2.push(st1.pop());
        }
        int ele = st2.peek();
        while(!st2.empty()) {
            st1.push(st2.pop());
        }
        return ele;
    }
    
    public boolean empty() {
        return st1.size() == 0 && st2.size() == 0;
    }
}
**/

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */