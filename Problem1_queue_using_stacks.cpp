#include <queue>
#include <limits.h>

class MyQueue {
private:
    stack<int> in_stack;
    stack<int> out_stack;

    bool out_stack_is_empty() {
        return INT_MAX == out_stack.top();
    }

    void populate_out_stack() {
        while (!in_stack.empty()) {
            out_stack.push(in_stack.top());
            in_stack.pop();
        }
    }

public:
    MyQueue() {
        out_stack.push(INT_MAX);               
    }

    void push(int x) {
        in_stack.push(x);
    }
    
    int pop() {
        if (out_stack_is_empty()) {
            populate_out_stack();    
        }
        
        int top = out_stack.top();
        out_stack.pop();
        
        return top;
    }
    
    int peek() {
        if (out_stack_is_empty()) {
            populate_out_stack();    
        }

        return out_stack.top();
    }
    
    bool empty() {
        return in_stack.empty() && out_stack_is_empty();
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