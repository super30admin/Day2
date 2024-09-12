// Time Complexity : O(1) for push, O(N) for pop, O(N) for peek, O(1) for empty
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue1 {
    Stack<Integer> stack1, stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                if(!stack2.isEmpty()){return stack2.pop();}
            }
        }
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack2.isEmpty()){
                return stack2.peek();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                if(!stack2.isEmpty()){return stack2.peek();}
            }
        }
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}

// Time Complexity : O(N) for push, O(1) for pop, O(1) for peek, O(1) for empty
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue2 {
    Stack<Integer> stack1, stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack2.isEmpty()){
           return stack2.pop();
        }
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}