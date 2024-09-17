// Time Complexity: push : O(1), pop,peek O(n)  , empty O(1) because we keep counter of items in the stack. 
// Space Complexity: push ? , pop O(2n), peek O(2n), empty O(1)?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not really, was trying to figure out why two stack were needed, but just seems like the wrong data structure to use if we want to imitate a queue.


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> originalStack;
    Stack<Integer> tempStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        originalStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        originalStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //Move all items til the last item in the stack to a temp stack. Then once we get the item, move back the temp stack. 
        tempStack = new Stack<Integer>();
        while(originalStack.size() > 1){
            tempStack.push(originalStack.pop());
        }
        int answer = originalStack.pop();
        
        while(tempStack.size() > 0){
            originalStack.push(tempStack.pop());
        }
        
        return answer;
    }
    
    /** Get the front element. */
    public int peek() {
        tempStack = new Stack<Integer>();
        while(originalStack.size() > 1){
            tempStack.push(originalStack.pop());
        }
        int answer = originalStack.pop();
        tempStack.push(answer);
        while(tempStack.size() > 0){
            originalStack.push(tempStack.pop());
        }
        return answer;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return originalStack.empty();
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