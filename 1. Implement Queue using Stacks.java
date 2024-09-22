// Time Complexity : O(1) - Amortized time complexity (Worst case is O(N) but the worst case is rare here, on average it will be O(1).
// Space Complexity : O(N) space complexity where N is the number of elements (we are using 2 stacks though)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting used to Java Syntax, confusing between True(Python) and true(Java). Messing up semicolons etc


// Your code here along with comments explaining your approach
// The idea is to use 2 stacks approach. When there is a pop operation, check if the outStack is empty and push all elements from in stack to out stack. Simply pop the top element.
// When push is given, simply push the element into in Stack
// when peek is given, empty in stack into out stak and then peek at the out stack to get the first element in queue
// for isEmpty operation simply check to see if both stacks are empty, then true else false.

class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }
    
    public void push(int x) {
        inSt.push(x);
    }
    
    public int pop() {
        if (outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }

        }
        return outSt.pop();
    }
    
    public int peek() { 
        if (outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }
    
    public boolean empty() {
        if (inSt.isEmpty() && outSt.isEmpty()){
            return true;
        }
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
