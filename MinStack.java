//Difficulties: On Popping the lement one needs to update the top pointer in the Min Stack otherwise WHen Min Operation comes after Pop, the min Stack.peek() 
//will be looking for the same element;
//Code Run on leetcode: Yes
//TC: O(1)
// SC: O(n)

class MinStack {

    Stack<Integer> s;
    Stack<Integer> minStack;  
    int min;
    
    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
        min=Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min,val);
        s.push(val); 
        minStack.push(min);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min=minStack.peek();//Need to do this as user may say I wish to see the min after the min has been removed;
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
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
