// Time Complexity :O(1) // average / amortized time complexity.
// Space Complexity : O(n) where is the total number of elements 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    stack<int> s1,s2;
public:
    /** Initialize your data structure here. */
    MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);  //push to first stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        peek();
        int val = s2.top(); // remove the element at the top
        s2.pop();
        return val;
    }
    
    /** Get the front element. */
    int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.top()); //if stack2 is empty fetch all the elements from stack 1
                s1.pop();
            }
        }
        return s2.top();  //return top
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return s1.empty() && s2.empty();  //check empty
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