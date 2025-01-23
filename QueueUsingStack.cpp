// Time Complexity : O(1) for push and amortized O(1) for pop
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack>

using namespace std;
class MyQueue {
    private:
    stack<int> in;
    stack<int> out;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        if(out.empty()){
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        }
        
        int v = out.top();
        out.pop();
        return v;
    }
    
    int peek() {
        if(out.empty()){
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
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