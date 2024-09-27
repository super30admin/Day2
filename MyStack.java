// Time Complexity : O(1) for Push O(N) for Pop
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No

class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> in;
    Queue<Integer> out;
    int front;
    
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        in.add(x);
        front = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (in.size()>1){
            front = in.poll();
            out.add(front);
        }
        int num = in.poll();
        while (!out.isEmpty()){
            int x = out.poll();
            in.add(x);
        }
        return num;
    }
    
    /** Get the top element. */
    public int top() {
        return front;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */