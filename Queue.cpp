// Time Complexity : O(1) and pop in O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int>s;
    int front;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s.push(x);
        if(s.size()==1)
            front = s.top();
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        stack<int>s1;
        while(!s.empty()){
            s1.push(s.top());
            s.pop();
        }
        int res = s1.top();
        s1.pop();
        if(s1.size()>=1)
         front = s1.top();
        while(!s1.empty()){
            s.push(s1.top());
            s1.pop();
        }
        return res;
    }
    
    /** Get the front element. */
    int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(s.empty())
            return true;
        return false;
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