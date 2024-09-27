
// # Design queue using stack (https://leetcode.com/problems/implement-queue-using-stacks/submissions/)
//  # Time complexity: push()=O(1), peek()=O(1), pop()=O(1), isEmpty()=O(1) 
//  # Space complexity: O(n), where n=number of elements
//  # Did this code successfully run on Leetcode : Yes
//  # Approach: Used two stacks, s1 and s2. Use s1 stack to push values and used s2 stack to peek and pop the values
 // Any problem you faced while coding this : No 

class MyQueue {
public:
    /** Initialize your data structure here. */
   stack<int> s1;
   stack<int> s2;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        
        if(!s2.empty()){
            int ele= s2.top();
            s2.pop();
            return ele;
        }
        peek();
        int ele = s2.top();
        s2.pop();
        return ele;
    }
    
    /** Get the front element. */
    int peek() {
        if(!s2.empty()){
            return s2.top();
        }
        
        while(!s1.empty()){
            int ele= s1.top();
            s1.pop();
            s2.push(ele);
            
        }
        
        return s2.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (s1.empty() && s2.empty());
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */