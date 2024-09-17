// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Coming up with the logic of buckets


class QueueStack {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
        
    public MyQueue() {
        
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int ans = second.pop();
        while(!second.empty()){
            first.push(second.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int ans = second.peek();
        while(!second.empty()){
            first.push(second.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return first.empty();
    }
}

