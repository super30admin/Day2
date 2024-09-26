// Time complexity push-> O(1),pop and peek O(1) amortized time can be O(n) worst time, remove O(1) empty-O(1)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

#include<iostream>
using namespace std;
#include<vector>
#include<stack>

class MyQueue {
public:
    stack<int> in_stack;
    stack<int> out_stack;
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        in_stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(!out_stack.empty()){
            int res= out_stack.top();
            out_stack.pop(); 
            return res;
        }
    
        while (!in_stack.empty())
            {
                out_stack.push(in_stack.top());
                in_stack.pop();
            }
        int res= out_stack.top();
            out_stack.pop(); 
        return res;
    }
    
    /** Get the front element. */
    int peek() {
        if(!out_stack.empty()){
            return out_stack.top();
           
        }
    
        while (!in_stack.empty())
            {
                out_stack.push(in_stack.top());
                in_stack.pop();
            }
            return out_stack.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return in_stack.empty() && out_stack.empty();
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