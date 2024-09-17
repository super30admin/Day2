// Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity : Push -> O(1) , Pop -> O(1) Amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
public:
    stack<int> in;
    stack<int> out;
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        peek();
        int x = out.top();
        out.pop();
        return x;
    }
    
    int peek() {
        if(out.empty()){
            while(!in.empty()){
                int x = in.top();
                 in.pop();
                out.push(x);
               
            }
        }
        return out.top();
    }
    
    bool empty() {
        return in.empty() && out.empty();
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