class MyQueue {
    // Time Complexity : Pop -> O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1  = new Stack<Integer>();
        s2  = new Stack<Integer>();

    }

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if(!s1.empty()){
            return s1.pop();
        }
        transfer();
        return s1.pop();
    }

    public int peek() {
        if(!s1.empty()){
            return s1.peek();
        }
        transfer();
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    public void transfer(){
        while(!s2.empty()){
            s1.push(s2.pop());
        }
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