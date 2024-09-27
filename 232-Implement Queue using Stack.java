// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: Tried to solve in python, being new to python could not copmlete it and has to switch back to java


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> left;
    Stack<Integer> right;
    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }
    
    public void push(int x) {
        left.push(x);
    }
    
    public int pop() {
        peek();
        return right.pop();
    }
    
    public int peek() {
        if(right.isEmpty()){
            while (!left.isEmpty()){
                right.push(left.pop());
            }
        }
        return right.peek();
    }
    
    public boolean empty() {
        if (right.isEmpty() && left.isEmpty()){
            return true;
        }
        else{
            return false;
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