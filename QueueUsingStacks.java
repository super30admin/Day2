// Time Complexity : O (1) push, O (1) asymptotic average pop
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
        if (!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
