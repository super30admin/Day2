// Time Complexity : Pop - O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Used 2 stacks, used aux stack for retrieivng the order of elements.

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
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