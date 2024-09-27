// Time Complexity : O(n) for pop and peek, rest all O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyQueue {
    
    stack<int> in, out;
    
public:
    MyQueue() {
        in = stack<int>();
        out = stack<int>();
    }
    
    void push(int x) {
        in.push(x);
    }
    
    void transfer() {
        if (out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        }
    }
    
    int pop() {
        transfer();
        int t = out.top();
        out.pop();
        return t;
    }
    
    int peek() {
        transfer();
        return out.top();
    }
    
    bool empty() {
        return (in.empty() && out.empty());
    }
};
