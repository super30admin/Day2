// Time Complexity : I think O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No :D

//It did poorly wrt space complexity 

class MyQueue {
    stack<int> s;
    stack<int> q;
public:
    /** Initialize your data structure here. */
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
        int t=q.top();
        q.pop();
        return t;
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
