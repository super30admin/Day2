// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> stack= new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();
    int min;    
    
    public MinStack() { 
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) { //O(1)
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }
    
    public void pop() { //O(1)
        stack.pop();
        minStack.pop();
    }
    
    public int top() { //O(1)
        return stack.peek();
    }
    
    public int getMin() { //O(1)
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
