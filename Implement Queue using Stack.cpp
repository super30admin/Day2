// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int>s;
    stack<int>q;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(q.empty()){
            while(!s.empty()){
                q.push(s.top());
                s.pop();
            }
        }
        int result = q.top();
        q.pop();
        return result;
    }
    
    /** Get the front element. */
    int peek() {
        if(q.empty()){
            while(!s.empty()){
                q.push(s.top());
                s.pop();
            }
        }
        return q.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(q.empty()){
            while(!s.empty()){
                q.push(s.top());
                s.pop();
            }
        }
        if(q.empty()){
            return true;
        }
        else{
            return false;
        }
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
