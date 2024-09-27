// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
// I will take 2 stacks and I will pop each elemnt from forst stack and push it to second stack, 
//while poping elements from second stack it acts as queue.

class QueueUsingStack {
    Stack<Integer> stck1;
    Stack<Integer> stck2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stck1=new Stack<Integer>();
        stck2=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stck1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stck2.empty()){
            while(!stck1.empty()){
                stck2.push(stck1.pop());
            }
        }
        if(stck2.empty()) return -1;
        return stck2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stck2.empty()){
            while(!stck1.empty()){
                stck2.push(stck1.pop());
            }
        }
        if(stck2.empty()) return -1;
        return stck2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stck1.empty() && stck2.empty());
    }
}
