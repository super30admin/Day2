// Time Complexity : push: O(1), pop(), peek(): O(n) worst case, but O(1) on an average, empty(): O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Got to know that, unlike Java, C++ stack's pop() is a void function


// Your code here along with comments explaining your approach


#include<stack>
class MyQueue {
    stack<int> in;
    stack<int> out;

    void transferFromInToOutStack()
    {
        while(in.empty() == false)
        {
            out.push(in.top());
            in.pop();
        }
    }
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        // If 'out' stack is empty, 
        // transfer from 'in' stack to 'out' stock to get 
        // the top element for queue. 
        if(out.empty())
        {
            transferFromInToOutStack();
        }
        // C++ pop() is a void function
        int popped_val = out.top();
        out.pop();
        return popped_val;
    }
    
    int peek() {
        if (out.empty())
        {
            transferFromInToOutStack();
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